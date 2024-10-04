package com.example.eldorado.service;

import com.example.eldorado.entidades.Stopover;
import org.springframework.stereotype.Service;
import com.example.eldorado.repository.StopoverRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StopoverServiceImp implements StopoverService {

    private final StopoverRepository stopoverRepository;

    public StopoverServiceImp(StopoverRepository stopoverRepository) {
        this.stopoverRepository = stopoverRepository;
    }

    @Override
    public List<Stopover> findAll() {
        return stopoverRepository.findAll();
    }

    @Override
    public Optional<Stopover> find(int id) {
        return stopoverRepository.findById(id);
    }

    @Override
    public Stopover create(Stopover stopover) {
        Stopover newStopover = new Stopover();
        newStopover.setStopoverTime(stopover.getStopoverTime());
        newStopover.setFlights(stopover.getFlights());

        return stopoverRepository.save(newStopover);
    }

    @Override
    public Optional<Stopover> update(int id, Stopover newStopover) {
        return stopoverRepository.findById(id).map(StopoverInDB -> {
            StopoverInDB.setStopoverTime(newStopover.getStopoverTime());
            StopoverInDB.setFlights(newStopover.getFlights());

            return stopoverRepository.save(StopoverInDB);
        });
    }

    @Override
    public void delete(int id) {
        stopoverRepository.deleteById(id);
    }

    @Override
    public List<Stopover> findBystopoverTime(LocalDate stopoverTime) {
        return stopoverRepository.findByStopoverTime(stopoverTime);
    }
}
