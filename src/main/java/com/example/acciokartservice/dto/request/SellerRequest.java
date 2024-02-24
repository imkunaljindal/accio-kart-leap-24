package com.example.acciokartservice.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SellerRequest {

    String name;

    String mobileNumber;

    int age;
}
