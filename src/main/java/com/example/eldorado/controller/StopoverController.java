package com.example.eldorado.controller;

import com.example.eldorado.entity.Stopover;
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
    public ResponseEntity<List<Stopover>> getAllStopover(){
        return ResponseEntity.ok(stopoverService.findAll());
    }

    @GetMapping("/stopover/{id}")
    public ResponseEntity<Stopover> getReservationById(@PathVariable Integer id) {
        Optional<Stopover> stopover = stopoverService.find(id);

        return stopover.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity<Stopover> createReservation(@RequestBody Stopover stopover) throws URISyntaxException {
        Stopover newStopover = stopoverService.create(stopover);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newStopover.getId())
                .toUri();

        return ResponseEntity.created(location).body(newStopover);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stopover> update(@PathVariable int id, @RequestBody Stopover stopover) {
        Optional<Stopover> stopoverUpdated = stopoverService.update(id, stopover);
        return stopoverUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Stopover newStopover = stopoverService.create(stopover);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newStopover.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newStopover);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStopover(@PathVariable int id) {
        stopoverService.delete(id);
        return ResponseEntity.noContent().build();
    }

}