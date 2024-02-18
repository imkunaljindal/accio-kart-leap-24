package com.example.acciokartservice.service;

import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.model.Identity;
import com.example.acciokartservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public IdentityService(CustomerService customerService,
                           CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    public void addIdentity(Identity identity, String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        customer.setIdentity(identity);
        customerRepository.save(customer);
    }
}
