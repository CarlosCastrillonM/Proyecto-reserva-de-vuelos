package com.example.eldorado.controller;

import com.example.eldorado.dto.AirportDto;
import com.example.eldorado.entity.Airport;
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
    public ResponseEntity<List<AirportDto>> getAllAirport(){
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/airport/{id}")
    public ResponseEntity<AirportDto> getAirportById(@PathVariable Integer id) {
        Optional<AirportDto> airportDto = airportService.find(id);

        return airportDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) throws URISyntaxException {
        AirportDto newAirportDto = airportService.create(airportDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAirportDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAirportDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirportDto> update(@PathVariable int id, @RequestBody AirportDto airportDto) {
        Optional<AirportDto> airportUpdated = airportService.update(id, airportDto);
        return airportUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    AirportDto newAirportDto = airportService.create(airportDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirportDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirportDto);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirport(@PathVariable int id) {
        airportService.delete(id);
        return ResponseEntity.noContent().build();
    }

}