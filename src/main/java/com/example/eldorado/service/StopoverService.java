package com.example.eldorado.service;

import com.example.eldorado.dto.StopoverDto;
import com.example.eldorado.entity.Stopover;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StopoverService {

    List<StopoverDto> findAll();
    Optional<StopoverDto> find(int id);
    StopoverDto create(StopoverDto stopoverDto);
    Optional<StopoverDto> update(int id, StopoverDto newStopOverDto);
    void delete(int id);
    List<StopoverDto> findByStopoverTime(LocalDate stopoverTime);
}
