package com.example.acciokartservice.service;

import com.example.acciokartservice.Enum.Gender;
import com.example.acciokartservice.dto.request.CustomerRequest;
import com.example.acciokartservice.dto.response.CustomerResponse;
import com.example.acciokartservice.exception.CustomerNotFoundException;
import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.repository.CustomerRepository;
import com.example.acciokartservice.service.transfomer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public CustomerResponse getCustomer(int customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        return CustomerTransformer.customerToCustomerResponse(optionalCustomer.get());
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

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender, age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer: customers){
            customerResponses.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public int getCountOfAgeGreaterThan(int age) {
        return customerRepository.getCountOfAgeGreaterThan(age);
    }

    public int getCountOfGender(String gender) {
        return customerRepository.getCountOfGender(gender);
    }
}
