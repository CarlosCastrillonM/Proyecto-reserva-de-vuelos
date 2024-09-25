package service;

import com.example.eldorado.entidades.Stopover;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StopoverService {

    List<Stopover> findAll();
    Optional<Stopover> find(int id);
    Stopover create(Stopover stopOver);
    Optional<Stopover> update(int id, Stopover newStopOver);
    void delete(int id);
    List<Stopover> findBystopoverTime(LocalDate stopoverTime);
}
