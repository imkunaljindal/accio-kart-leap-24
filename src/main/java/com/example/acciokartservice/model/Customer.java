package com.example.acciokartservice.model;

import com.example.acciokartservice.Enum.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="customer")
public class Customer {

    @Id
    int id;

    @Column(name="name")
    String name;

    @Column(unique = true,nullable = false)
    @Email
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Size(min = 2, max = 20)
    String city;
}
