package com.example.acciokartservice.dto.request;

import com.example.acciokartservice.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest {

    String name;

    String emailId;

    int age;

    Gender gender;

    String city;
}
