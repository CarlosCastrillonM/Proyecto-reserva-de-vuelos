package com.example.eldorado.service;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.dto.ReservationDto;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<ReservationDto> findAll();
    Optional<ReservationDto> find(int id);
    ReservationDto create(ReservationDto reservationDto);
    Optional<ReservationDto> update(int id, ReservationDto newReservationDto);
    void delete(int id);
    List<CustomerDto> findByCustomer(CustomerDto customerDto);
}
