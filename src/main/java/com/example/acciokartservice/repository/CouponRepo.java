package com.example.acciokartservice.repository;

import com.example.acciokartservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,Integer> {
}
