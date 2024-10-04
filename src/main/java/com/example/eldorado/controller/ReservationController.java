package com.example.eldorado.controller;

import com.example.eldorado.entidades.Reservation;
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
@RequestMapping("/api/v5")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.findAll());
    }

    @GetMapping("/reservation/idReservation")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Integer id) {
        Optional<Reservation> reservation = reservationService.find(id);

        if(reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws URISyntaxException {
        Reservation newReservation = reservationService.create(reservation);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newReservation.getId())
                .toUri();

        return ResponseEntity.created(location).body(newReservation);
    }

    @PutMapping("/id")
    public ResponseEntity<Reservation> update(@PathVariable int id, @RequestBody Reservation reservation) {
        Optional<Reservation> reservationUpdated = reservationService.update(id, reservation);
        return reservationUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Reservation newReservation = reservationService.create(reservation);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newReservation.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newReservation);
                });
    }

}