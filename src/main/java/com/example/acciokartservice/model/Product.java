package com.example.acciokartservice.model;

import com.example.acciokartservice.Enum.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String productName;

    double price;

    int quantityAvailable;

    @Enumerated(EnumType.STRING)
    ProductStatus productStatus;

    String description;

    @ManyToOne
    @JoinColumn(name="seller_id")
    Seller lowes;

}
