package com.example.eldorado.service;

import com.example.eldorado.entidades.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAll();
    Optional<Customer> find(int id);
    Customer create(Customer customer);
    Optional<Customer> update(int id, Customer newCustomer);
    void delete(int id);
    List<Customer> findCustomerByName(String name);

}
