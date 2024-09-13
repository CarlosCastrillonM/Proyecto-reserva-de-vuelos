package repository;

import com.example.eldorado.entidades.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    //Acá colocaré una Query
    List<Airline> findByName(String name);
}