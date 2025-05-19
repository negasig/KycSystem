package com.example.kycsystem_demo.Repository;

import com.example.kycsystem_demo.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
