package com.example.eldorado.service;

import com.example.eldorado.dto.AirlineDto;
import com.example.eldorado.entity.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.AirlineRepository;
import com.example.eldorado.mapper.AirlineMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImp implements  AirlineService{

    private final AirlineRepository airlineRepository;
    private AirlineMapper mapper;

    @Autowired
    public AirlineServiceImp(AirlineRepository airlineRepository, AirlineMapper mapper) {
        this.airlineRepository = airlineRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AirlineDto> findAll() {
        List<Airline> airlines = airlineRepository.findAll();
        List<AirlineDto> airlineDtos = new ArrayList<>();

        for (Airline entity : airlines) {
            airlineDtos.add(mapper.toDto(entity));
        }

        return airlineDtos;
    }

    @Override
    public Optional<AirlineDto> find(int id) {
        Optional<Airline> airlines = airlineRepository.findById(id);

        Optional<AirlineDto> airlineDtos;

        airlineDtos = airlines.map(mapper::toDto);
        return airlineDtos;
    }

    @Override
    public AirlineDto create(AirlineDto airlineDto) {
        Airline airlineEntity = new Airline();

        airlineEntity = mapper.toEntity(airlineDto);
        airlineEntity = airlineRepository.save(airlineEntity);

        airlineDto = mapper.toDto(airlineEntity);
        return airlineDto;
    }

    @Override
    public Optional<AirlineDto> update(int id, AirlineDto newAirlineDto) {

        return airlineRepository.findById(id).map(AirlineInDB -> {
            AirlineInDB = mapper.toEntity(newAirlineDto);
            AirlineInDB = airlineRepository.save(AirlineInDB);

            return mapper.toDto(AirlineInDB);
        });
    }

    @Override
    public void delete(int id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public List<AirlineDto> findByName(String name) {
        List<Airline> airlines = airlineRepository.findByName(name);
        List<AirlineDto> airlineDtos = new ArrayList<>();

        airlines = airlineRepository.findByName(name);

        for (Airline entity : airlines) {
            airlineDtos.add(mapper.toDto(entity));
        }

        return airlineDtos;
    }

}
