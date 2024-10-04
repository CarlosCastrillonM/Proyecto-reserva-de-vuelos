package com.example.eldorado.repository;

import com.example.eldorado.entidades.Customer;
import com.example.eldorado.entidades.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    @Query("SELECT res FROM Reservation res WHERE res.customer = ?1")
    List<Reservation> findByCustomer(Customer customer);
}
