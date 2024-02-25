package com.example.acciokartservice.service;

import com.example.acciokartservice.model.Coupon;
import com.example.acciokartservice.repository.CouponRepo;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

    private final CouponRepo couponRepo;

    public CouponService(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    public void addCoupon(String couponCode,
                            double percentageDiscount) {
        Coupon coupon = Coupon.builder()
                .couponCode(couponCode)
                .percentageDiscount(percentageDiscount)
                .build();
        couponRepo.save(coupon);
    }
}
