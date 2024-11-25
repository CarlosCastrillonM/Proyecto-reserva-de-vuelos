package com.example.eldorado.repository;

import com.example.eldorado.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    List<Airline> findByName(String name);
}
