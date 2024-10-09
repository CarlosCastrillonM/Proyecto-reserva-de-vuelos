package com.example.eldorado.dto;

import com.example.eldorado.entity.Customer;

public class ReservationDto {
    private Integer id;
    private Customer customer;

    public ReservationDto(Integer id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "ReservationDto{" +
               "id=" + id +
               ", customer=" + customer +
               '}';
    }
}
