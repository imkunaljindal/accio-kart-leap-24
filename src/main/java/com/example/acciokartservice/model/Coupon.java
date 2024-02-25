package com.example.acciokartservice.model;

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
@Table(name="coupon")
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String couponCode;

    double percentageDiscount;

    @ManyToMany
    @JoinTable(name="customers_coupons",
    joinColumns = {@JoinColumn(name="coupon_id")},
    inverseJoinColumns = {@JoinColumn(name="customer_id")})
    List<Customer> customers = new ArrayList<>();
}
