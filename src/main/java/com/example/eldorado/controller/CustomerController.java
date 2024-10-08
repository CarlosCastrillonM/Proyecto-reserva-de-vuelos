package com.example.eldorado.controller;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.entity.Customer;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Integer id) {
        Optional<CustomerDto> customerDto = customerService.find(id);

        return customerDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) throws URISyntaxException {
        CustomerDto newCustomerDto = customerService.create(customerDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCustomerDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newCustomerDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> update(@PathVariable int id, @RequestBody CustomerDto customerDto) {
        Optional<CustomerDto> customerUpdated = customerService.update(id, customerDto);
        return customerUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    CustomerDto newCustomerDto = customerService.create(customerDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newCustomerDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newCustomerDto);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}