package com.example.eldorado.controller;

import com.example.eldorado.entidades.Airline;
import com.example.eldorado.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airline")
public class AirlineController {
    private final AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airlines")
    public ResponseEntity<List<Airline>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/airlines/{idAirline}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable("idAirline") Integer id) {
        Optional<Airline> airline = airlineService.find(id);

        return airline.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
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

    @PutMapping("/{id}")
    public ResponseEntity<Airline> update(@PathVariable int id, @RequestBody Airline airline) {
        Optional<Airline> airlineUpdated = airlineService.update(id, airline);
        return airlineUpdated
                .map(ResponseEntity::ok)
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
