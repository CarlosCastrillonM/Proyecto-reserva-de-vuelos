package com.example.eldorado.repository;

import com.example.eldorado.entity.Customer;
import com.example.eldorado.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByCustomer(Customer customer);
}
