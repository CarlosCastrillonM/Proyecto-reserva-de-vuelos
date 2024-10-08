package com.example.eldorado.service;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDto> findAll();
    Optional<CustomerDto> find(int id);
    CustomerDto create(CustomerDto customerDto);
    Optional<CustomerDto> update(int id, CustomerDto newCustomerDto);
    void delete(int id);
    List<CustomerDto> findByName(String name);

}
