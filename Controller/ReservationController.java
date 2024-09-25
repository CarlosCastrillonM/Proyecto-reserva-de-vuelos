import com.example.eldorado.entidades.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import service.*
import java.util.List;

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
    public ResponseEntity<Reservation> getReservationById(@pathVariable Integer id) {
        Optional<Reservation> reservation = reservationService.find(id);

        if(reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) throws URISintaxException {
        Reservation newReservation = reservationService.create(reservation);

        URI location = servletUriComponentBuilder.fromCurrentRequest()
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