package com.example.eldorado.controller;

import com.example.eldorado.entidades.Airport;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airport")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airport")
    public ResponseEntity<List<Airport>> getAllAirport(){
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Integer id) {
        Optional<Airport> airport = airportService.find(id);

        return airport.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
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

    @PutMapping("/{id}")
    public ResponseEntity<Airport> update(@PathVariable int id, @RequestBody Airport airport) {
        Optional<Airport> airportUpdated = airportService.update(id, airport);
        return airportUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Airport newAirport = airportService.create(airport);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirport.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirport);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable int id) {
        airportService.delete(id);
        return ResponseEntity.noContent().build();
    }

}