package com.example.acciokartservice.service;

import com.example.acciokartservice.dto.request.ProductRequest;
import com.example.acciokartservice.exception.SellerNotFoundException;
import com.example.acciokartservice.model.Product;
import com.example.acciokartservice.model.Seller;
import com.example.acciokartservice.repository.SellerRepository;
import com.example.acciokartservice.service.transfomer.ProductTransformer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    private final SellerRepository sellerRepository;

    public ProductService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Product addProduct(String sellerUniqueNumber,
                              ProductRequest productRequest) {

        Optional<Seller> optionalSeller = sellerRepository.findByUniqueSellerNumber(sellerUniqueNumber);
        if(optionalSeller.isEmpty()){
            throw new SellerNotFoundException("Invalid seller number!!!");
        }

        Seller seller = optionalSeller.get();

        Product product = ProductTransformer.productRequestToProduct(productRequest);

        // setting both the
        product.setSeller(seller);
        seller.getProducts().add(product);

        Seller savedSeller = sellerRepository.save(seller);
        return savedSeller.getProducts().get(savedSeller.getProducts().size()-1);

    }
}
