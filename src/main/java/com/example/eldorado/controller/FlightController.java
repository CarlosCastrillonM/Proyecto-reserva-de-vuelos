package com.example.eldorado.controller;

import com.example.eldorado.dto.FlightDto;
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
    public ResponseEntity<List<FlightDto>> getAllFlight(){
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/flight/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Integer id) {
        Optional<FlightDto> flightDto = flightService.find(id);

        return flightDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) throws URISyntaxException {
        FlightDto newFlightDto = flightService.create(flightDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newFlightDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newFlightDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> update(@PathVariable int id, @RequestBody FlightDto flightDto) {
        Optional<FlightDto> flightUpdated = flightService.update(id, flightDto);
        return flightUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    FlightDto newFlightDto = flightService.create(flightDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newFlightDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newFlightDto);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable int id) {
        flightService.delete(id);
        return ResponseEntity.noContent().build();
    }

}