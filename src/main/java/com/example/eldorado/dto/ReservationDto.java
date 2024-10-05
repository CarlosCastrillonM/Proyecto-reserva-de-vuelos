package com.example.eldorado.dto;

import com.example.eldorado.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReservationDto {
    private Integer id;
    private Customer customer;

    public ReservationDto(Integer id, Customer customer) {
        this.id = id;
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
