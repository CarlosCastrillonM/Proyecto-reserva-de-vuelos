package com.example.eldorado.controller;

import com.example.eldorado.entidades.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import com.example.eldorado.service.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1")
public class AirlineController {
    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/airlines/idAirline")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Integer id) {
        Optional<Airline> airline = airlineService.find(id);

        if(airline.isPresent()) {
            return ResponseEntity.ok(airline.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Airline> createAirline(@RequestBody Airline airline) throws URISyntaxException {
        Airline newAirline = airlineService.create(airline);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAirline.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAirline);
    }

    @PutMapping("/id")
    public ResponseEntity<Airline> update(@PathVariable int id, @RequestBody Airline airline) {
        Optional<Airline> airlineUpdated = airlineService.update(id, airline);
        return airlineUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Airline newAirline = airlineService.create(airline);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirline.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirline);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable int id) {
        airlineService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
