package com.example.eldorado.service;

import com.example.eldorado.dto.FlightDto;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    List<FlightDto> findAll();
    Optional<FlightDto> find(int id);
    FlightDto create(FlightDto flightDto);
    Optional<FlightDto> update(int id, FlightDto newFlightDto);
    void delete(int id);
    List<FlightDto> findByOrigin(String origin);
}
