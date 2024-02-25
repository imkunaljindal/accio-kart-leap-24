package com.example.acciokartservice.service.transfomer;

import com.example.acciokartservice.Enum.ProductStatus;
import com.example.acciokartservice.dto.request.ProductRequest;
import com.example.acciokartservice.model.Product;

public class ProductTransformer {

    public static Product productRequestToProduct(ProductRequest productRequest){
        return Product.builder()
                .productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantityAvailable(productRequest.getQuantityAvailable())
                .description(productRequest.getDescription())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }
}
