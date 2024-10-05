package com.example.eldorado.controller;

import com.example.eldorado.entity.Reservation;
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

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id) {
        Optional<Reservation> reservation = reservationService.find(id);

        return reservation.map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws URISyntaxException {
        Reservation newReservation = reservationService.create(reservation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newReservation.getId())
                .toUri();

        return ResponseEntity.created(location).body(newReservation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable int id, @RequestBody Reservation reservation) {
        Optional<Reservation> reservationUpdated = reservationService.update(id, reservation);
        return reservationUpdated
                .map(ResponseEntity::ok)
                .orElseGet(() -> {
                    Reservation newReservation = reservationService.create(reservation);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newReservation.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newReservation);
                });
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable int id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}