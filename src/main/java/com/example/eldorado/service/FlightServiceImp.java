package com.example.eldorado.service;

import com.example.eldorado.entidades.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImp implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImp(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> find(int id) {
        return flightRepository.findById(id);
    }

    @Override
    public Flight create(Flight flight) {
        Flight newFlight = new Flight();

        newFlight.setOrigin(flight.getOrigin());
        newFlight.setDestination(flight.getDestination());
        newFlight.setDepartureDate(flight.getDepartureDate());
        newFlight.setArrivalDate(flight.getArrivalDate());
        newFlight.setCapacity(flight.getCapacity());
        newFlight.setDuration(flight.getDuration());
        newFlight.setAirline(flight.getAirline());
        newFlight.setCustomers(flight.getCustomers());
        newFlight.setStopovers(flight.getStopovers());

        return flightRepository.save(newFlight);
    }

    @Override
    public Optional<Flight> update(int id, Flight newFlight) {
        return flightRepository.findById(id).map(FlightInDB -> {
            FlightInDB.setOrigin(newFlight.getOrigin());
            FlightInDB.setDestination(newFlight.getDestination());
            FlightInDB.setDepartureDate(newFlight.getDepartureDate());
            FlightInDB.setArrivalDate(newFlight.getArrivalDate());
            FlightInDB.setCapacity(newFlight.getCapacity());
            FlightInDB.setDuration(newFlight.getDuration());
            FlightInDB.setAirline(newFlight.getAirline());
            FlightInDB.setCustomers(newFlight.getCustomers());
            FlightInDB.setStopovers(newFlight.getStopovers());

            return flightRepository.save(FlightInDB);
        });
    }

    @Override
    public void delete(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> findByOrigin(String origin) {
        return flightRepository.findByOrigin(origin);
    }
}
