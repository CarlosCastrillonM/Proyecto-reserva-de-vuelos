package com.example.eldorado.repository;

import com.example.eldorado.entidades.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface FlightRepository extends JpaRepository <Flight, Integer> {
    @Query("SELECT flight FROM Flight flight WHERE flight.origin = ?1")
    List<Flight> findByOrigin(String origin);
}
