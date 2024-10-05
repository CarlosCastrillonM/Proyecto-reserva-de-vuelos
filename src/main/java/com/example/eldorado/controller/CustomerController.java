package com.example.eldorado.controller;

import com.example.eldorado.entidades.Customer;
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
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customer = customerService.find(id);

        return customer.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        Customer newCustomer = customerService.create(customer);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCustomer.getId())
                .toUri();

        return ResponseEntity.created(location).body(newCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable int id, @RequestBody Customer customer) {
        Optional<Customer> customerUpdated = customerService.update(id, customer);
        return customerUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Customer newCustomer = customerService.create(customer);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newCustomer.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newCustomer);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}