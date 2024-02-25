package com.example.acciokartservice.dto.response;

import com.example.acciokartservice.Enum.ProductStatus;

public class ProductResponse {

    int quantityAvailable;
    double price;
    ProductStatus productStatus;

    SellerResponse sellerResponse;
}
