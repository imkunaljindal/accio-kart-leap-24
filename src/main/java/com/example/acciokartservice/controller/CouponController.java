package com.example.acciokartservice.controller;

import com.example.acciokartservice.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam("code") String couponCode,
                                    @RequestParam("discount") double percentageDiscount){
        couponService.addCoupon(couponCode,percentageDiscount);
        return new ResponseEntity<>("Coupon added successfully", HttpStatus.CREATED);
    }
}
