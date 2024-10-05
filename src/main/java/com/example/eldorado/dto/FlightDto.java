package com.example.eldorado.dto;

import com.example.eldorado.entity.Airline;
import com.example.eldorado.entity.Airport;
import com.example.eldorado.entity.Customer;
import com.example.eldorado.entity.Stopover;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class FlightDto {
    private Integer id;
    private Airport origin;
    private Airport destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private Duration duration;
    private int capacity;
    private Airline airline;
    private List<Customer> customers;
    private List<Stopover> stopovers;

    public FlightDto(Integer id, Airport origin, Airport destination, LocalDate departureDate, LocalDate arrivalDate, Duration duration, int capacity, Airline airline, List<Customer> customers, List<Stopover> stopovers) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
        this.capacity = capacity;
        this.airline = airline;
        this.customers = customers;
        this.stopovers = stopovers;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
               "id=" + id +
               ", origin=" + origin +
               ", destination=" + destination +
               ", departureDate=" + departureDate +
               ", arrivalDate=" + arrivalDate +
               ", duration=" + duration +
               ", capacity=" + capacity +
               ", airline=" + airline +
               ", customers=" + customers +
               ", stopovers=" + stopovers +
               '}';
    }
}
