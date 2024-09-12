package service;

import com.example.eldorado.entidades.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> findAll();
    Optional<Airport> find(int id);
    Airport create(Airport customer);
    Optional<Airport> update(int id, Airport newCustomer);
    void delete(int id);
    List<Airport> findAirportByName(String name);
}
