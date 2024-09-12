package service;


import com.example.eldorado.entidades.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImp implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImp(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> find(int id) {
        return airportRepository.findById(id);
    }

    @Override
    public Airport create(Airport airport) {
        Airport newAirport = new Airport();
        newAirport.setName(airport.getName());
        return airportRepository.save(newAirport);
    }

    @Override
    public Optional<Airport> update(int id, Airport newAirport) {
        return airportRepository.findById(id)
                .map(AirportInDB -> {
                    AirportInDB.setName(newAirport.getName());
                    AirportInDB.setCity(newAirport.getCity());
                    AirportInDB.setCountry(newAirport.getCountry());
                    AirportInDB.setFlights(newAirport.getFlights());

                    return airportRepository.save(AirportInDB);
                });
    }

    @Override
    public void delete(int id) {
        airportRepository.deleteById(id);
    }

    @Override
    public List<Airport> findAirportByName(String name) {
        return airportRepository.findByName(name);
    }
}
