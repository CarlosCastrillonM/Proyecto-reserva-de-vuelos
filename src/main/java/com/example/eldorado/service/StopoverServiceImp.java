package com.example.eldorado.service;

import com.example.eldorado.dto.FlightDto;
import com.example.eldorado.dto.StopoverDto;
import com.example.eldorado.entity.Flight;
import com.example.eldorado.entity.Stopover;
import com.example.eldorado.mapper.StopoverMapper;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.StopoverRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StopoverServiceImp implements StopoverService {

    private final StopoverRepository stopoverRepository;
    private StopoverMapper mapper;

    public StopoverServiceImp(StopoverRepository stopoverRepository, StopoverMapper mapper) {
        this.stopoverRepository = stopoverRepository;
        this.mapper = mapper;
    }

    @Override
    public List<StopoverDto> findAll() {
        List<Stopover> stopovers = stopoverRepository.findAll();
        List<StopoverDto> stopoverDtos = new ArrayList<>();

        for (Stopover entity : stopovers) {
            stopoverDtos.add(mapper.toDto(entity));
        }

        return stopoverDtos;
    }

    @Override
    public Optional<StopoverDto> find(int id) {
        Optional<Stopover> stopovers = stopoverRepository.findById(id);

        Optional<StopoverDto> stopoverDtos;

        stopoverDtos = stopovers.map(mapper::toDto);
        return stopoverDtos;
    }

    @Override
    public StopoverDto create(StopoverDto stopoverDto) {
        Stopover stopoverEntity = new Stopover();

        stopoverEntity = mapper.toEntity(stopoverDto);
        stopoverEntity = stopoverRepository.save(stopoverEntity);

        stopoverDto = mapper.toDto(stopoverEntity);
        return stopoverDto;
    }

    @Override
    public Optional<StopoverDto> update(int id, StopoverDto newStopoverDto) {
        return stopoverRepository.findById(id).map(StopoverInDB -> {
            StopoverInDB = mapper.toEntity(newStopoverDto);
            StopoverInDB = stopoverRepository.save(StopoverInDB);

            return mapper.toDto(StopoverInDB);
        });
    }

    @Override
    public void delete(int id) {
        stopoverRepository.deleteById(id);
    }

    @Override
    public List<StopoverDto> findByStopoverTime(LocalDate stopoverTime) {
        List<Stopover> stopovers = stopoverRepository.findByStopoverTime(stopoverTime);
        List<StopoverDto> stopoverDtos = new ArrayList<>();

        for (Stopover entity : stopovers) {
            stopoverDtos.add(mapper.toDto(entity));
        }

        return stopoverDtos;
    }
}
