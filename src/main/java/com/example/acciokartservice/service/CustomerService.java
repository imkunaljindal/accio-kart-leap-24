package com.example.acciokartservice.service;

import com.example.acciokartservice.Enum.Gender;
import com.example.acciokartservice.exception.CustomerNotFoundException;
import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);  // returns saved customer
    }

    public Customer getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        return optionalCustomer.get();
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerByEmail(String email) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailId(email);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid Email Id");
        }
        return optionalCustomer.get();
    }

    public List<Customer> getAllByGenderAndAge(Gender gender, int age) {
        return customerRepository.findByGenderAndAge(gender, age);
    }
}
