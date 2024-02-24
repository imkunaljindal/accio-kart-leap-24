package com.example.acciokartservice.service.transfomer;

import com.example.acciokartservice.dto.request.CustomerRequest;
import com.example.acciokartservice.dto.response.CustomerResponse;
import com.example.acciokartservice.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
       return Customer.builder()
               .name(customerRequest.getName())
               .age(customerRequest.getAge())
               .city(customerRequest.getCity())
               .emailId(customerRequest.getEmailId())
               .gender(customerRequest.getGender())
               .build();
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .emailId(customer.getEmailId())
                .createdAt(customer.getCreated())
                .build();
    }
}
