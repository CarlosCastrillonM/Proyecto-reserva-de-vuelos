package com.example.eldorado.service;

import com.example.eldorado.entity.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> findAll();
    Optional<Airport> find(int id);
    Airport create(Airport airport);
    Optional<Airport> update(int id, Airport newAirport);
    void delete(int id);
    List<Airport> findAirportByName(String name);
}
