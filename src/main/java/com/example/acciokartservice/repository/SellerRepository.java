package com.example.acciokartservice.repository;

import com.example.acciokartservice.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    Optional<Seller> findByUniqueSellerNumber(String uniqueSellerNumber);
}
