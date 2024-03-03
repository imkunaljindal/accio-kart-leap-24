package com.example.acciokartservice.service;

import com.example.acciokartservice.Enum.ProductStatus;
import com.example.acciokartservice.dto.response.CustomerResponse;
import com.example.acciokartservice.dto.response.OrderResponse;
import com.example.acciokartservice.exception.CustomerNotFoundException;
import com.example.acciokartservice.exception.ProductNotFoundException;
import com.example.acciokartservice.model.Coupon;
import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.model.OrderEntity;
import com.example.acciokartservice.model.Product;
import com.example.acciokartservice.repository.CouponRepo;
import com.example.acciokartservice.repository.CustomerRepository;
import com.example.acciokartservice.repository.ProductRepo;
import com.example.acciokartservice.service.transfomer.OrderTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepo productRepo;
    private final CouponRepo couponRepo;

    public OrderResponse placeOrder(Map<String, Object> paramsMap) {
        String emailId = (String) paramsMap.get("customer-email");
        int productId = Integer.parseInt((String)paramsMap.get("product-id"));
        int quantityRequired = Integer.parseInt((String) paramsMap.get("quantity"));

        // steps -> validation
        Optional<Customer> customerOptional = customerRepository.findByEmailId(emailId);
        if(customerOptional.isEmpty()){
            throw new CustomerNotFoundException("Invalid email id");
        }

        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Invalid product id");
        }
        Product product = optionalProduct.get();
        if(product.getQuantityAvailable() < quantityRequired){
            throw new ProductNotFoundException("Insufficient quantity");
        }

        Customer customer = customerOptional.get();
        double totalValue = quantityRequired*product.getPrice();
        totalValue = applyDiscount(customer,totalValue);
        OrderEntity orderEntity = OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .numberOfItems(quantityRequired)
                .totalValue(totalValue)
                .build();

        customer.getOrders().add(orderEntity);
        // update product inventory
        product.setQuantityAvailable(product.getQuantityAvailable()-quantityRequired);
        if(product.getQuantityAvailable()==0){
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        }

        Customer savedCustomer = customerRepository.save(customer); // customer and order
        productRepo.save(product); // product

        // preapre response dto -> orderresponse
        OrderEntity latestOrder = savedCustomer.getOrders().get(customer.getOrders().size()-1);
        return OrderTransformer.prepareOrderResponse(latestOrder);
    }

    private double applyDiscount(Customer customer, double totalValue) {
        Optional<Coupon> optionalCoupon = couponRepo.getRandomCoupon(customer);
        if(optionalCoupon.isPresent()){
            Coupon coupon = optionalCoupon.get();
            totalValue = (totalValue*coupon.getPercentageDiscount())/100.0;
        }
        return totalValue;
    }
}
