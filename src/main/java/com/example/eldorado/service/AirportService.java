package com.example.eldorado.service;

import com.example.eldorado.dto.AirportDto;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<AirportDto> findAll();
    Optional<AirportDto> find(int id);
    AirportDto create(AirportDto airportDto);
    Optional<AirportDto> update(int id, AirportDto newAirportDto);
    void delete(int id);
    List<AirportDto> findByName(String name);
}
