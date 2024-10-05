package com.example.eldorado.repository;

import com.example.eldorado.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
    List<Airport> findByName(String name);
}
