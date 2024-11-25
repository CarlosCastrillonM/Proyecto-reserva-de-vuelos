package com.example.eldorado.repository;

import com.example.eldorado.entity.Stopover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface StopoverRepository extends JpaRepository<Stopover, Integer> {
    List<Stopover> findByStopoverTime(LocalDate stopoverTime);
}
