package com.example.eldorado.service;

import com.example.eldorado.entity.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<Flight> findAll();
    Optional<Flight> find(int id);
    Flight create(Flight flight);
    Optional<Flight> update(int id, Flight newFlight);
    void delete(int id);
    List<Flight> findByOrigin(String origin);
}
