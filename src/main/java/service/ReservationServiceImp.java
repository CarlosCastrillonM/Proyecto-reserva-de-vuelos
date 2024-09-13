package service;

import com.example.eldorado.entidades.Customer;
import com.example.eldorado.entidades.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImp implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImp(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> find(int id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation create(Reservation reservation) {
        Reservation newReservation = new Reservation();

        newReservation.setCustomer(reservation.getCustomer());

        return reservationRepository.save(newReservation);
    }

    @Override
    public Optional<Reservation> update(int id, Reservation newReservation) {
        return reservationRepository.findById(id).map(ReservationInDB -> {
            ReservationInDB.setCustomer(newReservation.getCustomer());

            return reservationRepository.save(ReservationInDB);
        });
    }

    @Override
    public void delete(int id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findByCustomer(Customer customer) {
        return reservationRepository.findByCustomer(customer);
    }
}
