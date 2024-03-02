package com.example.acciokartservice.controller;

import com.example.acciokartservice.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/assign")
    public ResponseEntity<String> assignCoupon(@RequestParam("email") String emailId,
                        @RequestParam("code") String couponCode){


        String message = couponService.assignCoupon(emailId, couponCode);
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }
}
