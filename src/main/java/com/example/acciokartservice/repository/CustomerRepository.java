package com.example.acciokartservice.repository;

import com.example.acciokartservice.Enum.Gender;
import com.example.acciokartservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
   Optional<Customer> findByEmailId(String email);

   List<Customer> findByAge(int age);

   List<Customer> findByGenderAndAge(Gender gender, int age);
}
