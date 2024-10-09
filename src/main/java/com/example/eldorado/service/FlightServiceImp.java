package com.example.eldorado.service;

import com.example.eldorado.dto.FlightDto;
import com.example.eldorado.entity.Flight;
import com.example.eldorado.mapper.FlightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.FlightRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {

    private final FlightRepository flightRepository;
    private FlightMapper mapper;

    @Autowired
    public FlightServiceImp(FlightRepository flightRepository, FlightMapper mapper) {
        this.flightRepository = flightRepository;
        this.mapper = mapper;
    }

    @Override
    public List<FlightDto> findAll() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = new ArrayList<>();

        for (Flight entity : flights) {
            flightDtos.add(mapper.toDto(entity));
        }

        return flightDtos;
    }

    @Override
    public Optional<FlightDto> find(int id) {
        Optional<Flight> flights = flightRepository.findById(id);

        Optional<FlightDto> flightDtos;

        flightDtos = flights.map(mapper::toDto);
        return flightDtos;
    }

    @Override
    public FlightDto create(FlightDto flightDto) {
        Flight flightEntity = new Flight();

        flightEntity = mapper.toEntity(flightDto);
        flightEntity = flightRepository.save(flightEntity);

        flightDto = mapper.toDto(flightEntity);
        return flightDto;
    }

    @Override
    public Optional<FlightDto> update(int id, FlightDto newFlightDto) {
        return flightRepository.findById(id).map(FlightInDB -> {
            FlightInDB = mapper.toEntity(newFlightDto);
            FlightInDB = flightRepository.save(FlightInDB);

            return mapper.toDto(FlightInDB);
        });
    }

    @Override
    public void delete(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<FlightDto> findByOrigin(String origin) {
        List<Flight> flights = flightRepository.findByOrigin(origin);
        List<FlightDto> flightDtos = new ArrayList<>();

        for (Flight entity : flights) {
            flightDtos.add(mapper.toDto(entity));
        }

        return flightDtos;
    }
}
