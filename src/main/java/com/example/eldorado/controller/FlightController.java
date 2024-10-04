package com.example.eldorado.controller;

import com.example.eldorado.entidades.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v4")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlight(){
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/flight/idFlight")
    public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
        Optional<Flight> flight = flightService.find(id);

        if(flight.isPresent()) {
            return ResponseEntity.ok(flight.get());

        } else {
            return ResponseEntity.notFound();
        }
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

    @PutMapping("/id")
    public ResponseEntity<Flight> update(@PathVariable int id, @RequestBody Flight flight) {
        Optional<Flight> flightUpdated = flightService.update(id, flight);
        return flightUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Flight newFlight = flightService.create(flight);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newFlight.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newFlight);
                });
    }


}