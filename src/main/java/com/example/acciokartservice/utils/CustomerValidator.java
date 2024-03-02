package com.example.acciokartservice.utils;

import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class CustomerValidator {

    private final CustomerRepository customerRepository;
    public boolean isValid(String email){
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(email);
        System.out.println(optionalCustomer.get().getName());
        return optionalCustomer.isPresent();
    }
}
