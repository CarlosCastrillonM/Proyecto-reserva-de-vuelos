package com.example.eldorado.service;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.entity.Customer;
import com.example.eldorado.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;
    private CustomerMapper mapper;

    @Autowired
    public CustomerServiceImp(CustomerRepository CustomerRepository, CustomerMapper mapper) {
        this.customerRepository = CustomerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerDto> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer entity : customers) {
            customerDtos.add(mapper.toDto(entity));
        }

        return customerDtos;
    }

    @Override
    public Optional<CustomerDto> find(int id) {
        Optional<Customer> customers = customerRepository.findById(id);

        Optional<CustomerDto> customerDtos;

        customerDtos = customers.map(mapper::toDto);
        return customerDtos;
    }

    @Override
    public CustomerDto create(CustomerDto customerDto) {
        Customer customerEntity = new Customer();

        customerEntity = mapper.toEntity(customerDto);
        customerEntity = customerRepository.save(customerEntity);

        customerDto = mapper.toDto(customerEntity);
        return customerDto;
    }

    @Override
    public Optional<CustomerDto> update(int id, CustomerDto newCustomerDto) {

        return customerRepository.findById(id).map(CustomerInDB -> {
            CustomerInDB = mapper.toEntity(newCustomerDto);
            CustomerInDB = customerRepository.save(CustomerInDB);

            return mapper.toDto(CustomerInDB);
        });
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> findByName(String name) {
        List<Customer> customers = customerRepository.findByName(name);
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer entity : customers) {
            customerDtos.add(mapper.toDto(entity));
        }

        return customerDtos;
    }
}
