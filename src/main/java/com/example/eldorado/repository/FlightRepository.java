package com.example.eldorado.repository;

import com.example.eldorado.entity.Airport;
import com.example.eldorado.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface FlightRepository extends JpaRepository <Flight, Integer> {
    List<Flight> findByOrigin(Airport origin);
}
