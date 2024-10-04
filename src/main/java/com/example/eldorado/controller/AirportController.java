package com.example.eldorado.controller;

import com.example.eldorado.entidades.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.eldorado.service.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airport")
    public ResponseEntity<List<Airport>> getAllAirport(){
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/airport/idAirport")
    public ResponseEntity<Airport> getAirportById(@PathVariable Integer id) {
        Optional<Airport> airport = airportService.find(id);

        if(airport.isPresent()) {
            return ResponseEntity.ok(airport.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) throws URISyntaxException {
        Airport newAirport = airportService.create(airport);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAirport.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAirport);
    }

    @PutMapping("/id")
    public ResponseEntity<Airport> update(@PathVariable int id, @RequestBody Airport airport) {
        Optional<Airport> airportUpdated = airportService.update(id, airport);
        return airportUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Airport newAirport = airportService.create(airport);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirport.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirport);
                });
    }


}