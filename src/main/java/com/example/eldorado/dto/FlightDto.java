package com.example.eldorado.dto;

import com.example.eldorado.entity.Airline;
import com.example.eldorado.entity.Airport;
import com.example.eldorado.entity.Customer;
import com.example.eldorado.entity.Stopover;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Stopover> getStopovers() {
        return stopovers;
    }

    public void setStopovers(List<Stopover> stopovers) {
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
