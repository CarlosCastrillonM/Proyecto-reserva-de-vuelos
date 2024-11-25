package com.example.eldorado.repository;

import com.example.eldorado.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    List<Customer> findByName(String name);
}
