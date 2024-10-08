package com.example.eldorado.service;

import com.example.eldorado.dto.AirportDto;
import com.example.eldorado.entity.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.AirportRepository;
import com.example.eldorado.mapper.AirportMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {

    private final AirportRepository airportRepository;
    private AirportMapper mapper;

    @Autowired
    public AirportServiceImp(AirportRepository airportRepository, AirportMapper mapper) {
        this.airportRepository = airportRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AirportDto> findAll() {
        List<Airport> airports = airportRepository.findAll();
        List<AirportDto> airportDtos = new ArrayList<>();

        for (Airport entity : airports) {
            airportDtos.add(mapper.toDto(entity));
        }

        return airportDtos;
    }

    @Override
    public Optional<AirportDto> find(int id) {
        Optional<Airport> airports = airportRepository.findById(id);

        Optional<AirportDto> airportDtos;

        airportDtos = airports.map(mapper::toDto);
        return airportDtos;
    }

    @Override
    public AirportDto create(AirportDto airportDto) {
        Airport airportEntity = new Airport();

        airportEntity = mapper.toEntity(airportDto);
        airportEntity = airportRepository.save(airportEntity);

        airportDto = mapper.toDto(airportEntity);
        return airportDto;
    }

    @Override
    public Optional<AirportDto> update(int id, AirportDto newAirportDto) {
        return airportRepository.findById(id).map(AirportInDB -> {
            AirportInDB = mapper.toEntity(newAirportDto);
            AirportInDB = airportRepository.save(AirportInDB);

            return mapper.toDto(AirportInDB);
        });
    }

    @Override
    public void delete(int id) {
        airportRepository.deleteById(id);
    }

    @Override
    public List<AirportDto> findByName(String name) {
        List<Airport> airports = airportRepository.findByName(name);
        List<AirportDto> airportDtos = new ArrayList<>();

        airports = airportRepository.findByName(name);

        for (Airport entity : airports) {
            airportDtos.add(mapper.toDto(entity));
        }

        return airportDtos;
    }
}
