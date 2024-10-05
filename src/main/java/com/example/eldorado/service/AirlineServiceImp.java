package com.example.eldorado.service;

import com.example.eldorado.entidades.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.AirlineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImp implements  AirlineService{

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImp(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public List<Airline> findAll() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<Airline> find(int id) {
        return airlineRepository.findById(id);
    }

    @Override
    public Airline create(Airline airline) {
        Airline newAirline = new Airline();
        newAirline.setName(airline.getName());
        newAirline.setCode(airline.getCode());
        newAirline.setCountryOrigin(airline.getCountryOrigin());
        newAirline.setFlights(airline.getFlights());

        return airlineRepository.save(newAirline);
    }

    @Override
    public Optional<Airline> update(int id, Airline newAirline) {
        return airlineRepository.findById(id).map(AirlineInDB -> {
            AirlineInDB.setName(newAirline.getName());
            AirlineInDB.setCode(newAirline.getCode());
            AirlineInDB.setCountryOrigin(newAirline.getCountryOrigin());
            AirlineInDB.setFlights(newAirline.getFlights());

            return airlineRepository.save(AirlineInDB);
        });
    }

    @Override
    public void delete(int id) {
        airlineRepository.deleteById(id);
    }

    @Override
    public List<Airline> findByName(String name) {
        return airlineRepository.findByName(name);
    }
}
