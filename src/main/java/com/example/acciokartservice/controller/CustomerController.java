package com.example.acciokartservice.controller;

import com.example.acciokartservice.Enum.Gender;
import com.example.acciokartservice.dto.request.CustomerRequest;
import com.example.acciokartservice.dto.response.CustomerResponse;
import com.example.acciokartservice.model.Customer;
import com.example.acciokartservice.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") int customerId){
        return customerService.getCustomer(customerId);
    }

    @GetMapping("/get-all")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/email/{email}")
    public Customer getCustomerByEmail(@PathVariable("email") String email){
        return customerService.getCustomerByEmail(email);
    }

    // give me all the customers of a particular gender and a particular age
    // ex - all males of age 25
    @GetMapping("/get-by-gender-age")
    public List<CustomerResponse> getAllByGenderAndAge(@RequestParam("gender") Gender gender,
                                               @RequestParam("age") int age){
        return customerService.getAllByGenderAndAge(gender,age);
    }

    @GetMapping("/get-count")
    public int getCountOfAgeGreaterThan(@RequestParam("age") int age){
        return customerService.getCountOfAgeGreaterThan(age);
    }

    @GetMapping("/get-count-gender")
    public int getCountOfGender(@RequestParam("gender") String gender){
        return customerService.getCountOfGender(gender);
    }
}
