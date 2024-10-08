package com.example.eldorado.service;

import com.example.eldorado.dto.AirlineDto;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    List<AirlineDto> findAll();
    Optional<AirlineDto> find(int id);
    AirlineDto create(AirlineDto airlineDto);
    Optional<AirlineDto> update(int id, AirlineDto newAirlineDto);
    void delete(int id);
    List<AirlineDto> findByName(String name);
}
