package com.example.eldorado.controller;

import com.example.eldorado.dto.ReservationDto;
import com.example.eldorado.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationDto>> getAllReservation(){
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Integer id) {
        Optional<ReservationDto> reservationDto = reservationService.find(id);

        return reservationDto.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) throws URISyntaxException {
        ReservationDto newReservationDto = reservationService.create(reservationDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newReservationDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(newReservationDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> update(@PathVariable int id, @RequestBody ReservationDto reservationDto) {
        Optional<ReservationDto> reservationUpdated = reservationService.update(id, reservationDto);
        return reservationUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    ReservationDto newReservationDto = reservationService.create(reservationDto);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newReservationDto.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newReservationDto);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}