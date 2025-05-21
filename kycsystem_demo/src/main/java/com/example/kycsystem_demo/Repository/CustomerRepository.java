package com.example.kycsystem_demo.Repository;

import com.example.kycsystem_demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByusername(String username);
}
