package com.example.eldorado.controller;

import com.example.eldorado.dto.StopoverDto;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stopover")
public class StopoverController {
    private final StopoverService stopoverService;

    public StopoverController(StopoverService stopoverService) {
        this.stopoverService = stopoverService;
    }

    @GetMapping("/stopover")
    public ResponseEntity<List<StopoverDto>> getAllStopover(){
        return ResponseEntity.ok(stopoverService.findAll());
    }

    @GetMapping("/stopover/{id}")
    public ResponseEntity<StopoverDto> getReservationById(@PathVariable Integer id) {
        Optional<StopoverDto> stopoverDto = stopoverService.find(id);

        return stopoverDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<StopoverDto> createReservation(@RequestBody StopoverDto stopoverDto) throws URISyntaxException {
        StopoverDto newStopoverDto = stopoverService.create(stopoverDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newStopoverDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newStopoverDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StopoverDto> update(@PathVariable int id, @RequestBody StopoverDto stopoverDto) {
        Optional<StopoverDto> stopoverUpdated = stopoverService.update(id, stopoverDto);
        return stopoverUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    StopoverDto newStopoverDto = stopoverService.create(stopoverDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newStopoverDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newStopoverDto);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStopover(@PathVariable int id) {
        stopoverService.delete(id);
        return ResponseEntity.noContent().build();
    }

}