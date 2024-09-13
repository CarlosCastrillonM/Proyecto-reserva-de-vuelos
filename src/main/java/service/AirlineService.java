package service;

import com.example.eldorado.entidades.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    List<Airline> findAll();
    Optional<Airline> find(int id);
    Airline create(Airline airline);
    Optional<Airline> update(int id, Airline newAirline);
    void delete(int id);
    List<Airline> findAirlineByName(String name);
}
