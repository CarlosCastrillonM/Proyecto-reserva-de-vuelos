package com.example.eldorado.controller;

import com.example.eldorado.dto.AirlineDto;
import com.example.eldorado.entity.Airline;
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
    public ResponseEntity<List<AirlineDto>> getAllAirlines(){
        return ResponseEntity.ok(airlineService.findAll());
    }

    @GetMapping("/airlines/{idAirline}")
    public ResponseEntity<AirlineDto> getAirlineById(@PathVariable("idAirline") Integer id) {
        Optional<AirlineDto> airlineDto = airlineService.find(id);

        return airlineDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<AirlineDto> createAirline(@RequestBody AirlineDto airlineDto) throws URISyntaxException {
        AirlineDto newAirlineDto = airlineService.create(airlineDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAirlineDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAirlineDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirlineDto> update(@PathVariable int id, @RequestBody AirlineDto airlineDto) {
        Optional<AirlineDto> airlineUpdated = airlineService.update(id, airlineDto);
        return airlineUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    AirlineDto newAirlineDto = airlineService.create(airlineDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirlineDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirlineDto);
                });
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirline(@PathVariable int id) {
        airlineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
