package service;

import com.example.eldorado.entidades.Customer;
import com.example.eldorado.entidades.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAll();
    Optional<Reservation> find(int id);
    Reservation create(Reservation reservation);
    Optional<Reservation> update(int id, Reservation newReservation);
    void delete(int id);
    List<Reservation> findByCustomer(Customer customer);
}