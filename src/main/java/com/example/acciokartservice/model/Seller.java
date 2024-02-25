package com.example.acciokartservice.model;

import com.example.acciokartservice.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String uniqueSellerNumber;

    String name;

    @Column(unique = true)
    String mobileNumber;

    int age;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    List<Product> products = new ArrayList<>();

}
