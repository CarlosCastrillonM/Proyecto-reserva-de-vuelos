package com.example.eldorado.controller;

import com.example.eldorado.entity.Flight;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/flight")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlight(){
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
        Optional<Flight> flight = flightService.find(id);

        return flight.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) throws URISyntaxException {
        Flight newFlight = flightService.create(flight);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newFlight.getId())
                .toUri();

        return ResponseEntity.created(location).body(newFlight);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> update(@PathVariable int id, @RequestBody Flight flight) {
        Optional<Flight> flightUpdated = flightService.update(id, flight);
        return flightUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Flight newFlight = flightService.create(flight);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newFlight.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newFlight);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {
        flightService.delete(id);
        return ResponseEntity.noContent().build();
    }

}