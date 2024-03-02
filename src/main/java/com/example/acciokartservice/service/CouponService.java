package com.example.acciokartservice.service;

import com.example.acciokartservice.exception.CouponNotFoundException;
import com.example.acciokartservice.exception.CustomerNotFoundException;
import com.example.acciokartservice.model.Coupon;
import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.repository.CouponRepo;
import com.example.acciokartservice.repository.CustomerRepository;
import com.example.acciokartservice.utils.CustomerValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {

    private final CouponRepo couponRepo;
    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void addCoupon(String couponCode,
                            double percentageDiscount) {
        Coupon coupon = Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepo.save(coupon);
    }

    public String assignCoupon(String emailId, String couponCode) {
        if(!customerValidator.isValid(emailId)){
           throw new CustomerNotFoundException("Invalid customer email");
        }

        Optional<Coupon> couponOptional = couponRepo.findByCouponCode(couponCode);
        if(couponOptional.isEmpty()){
            throw new CouponNotFoundException("Invalid coupon code");
        }

        Coupon coupon = couponOptional.get();
        Customer customer = customerRepository.findByEmailId(emailId).get();
        coupon.getCustomers().add(customer);
        couponRepo.save(coupon);

        return "Coupon assigned successfully !!";
    }
}
