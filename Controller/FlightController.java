import com.example.eldorado.entidades.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import service.*
import java.util.List;

@RestController
@RequestMapping("/api/v4")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlight(){
        return ResponseEntity.ok(flightService.findAll());
    }

    @GetMapping("/flight/idFlight")
    public ResponseEntity<Flight> getFlightById(@pathVariable Integer id) {
        Optional<Flight> flight = flightService.find(id);

        if(flight.isPresent()) {
            return ResponseEntity.ok(flight.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) throws URISintaxException {
        Flight newFlight = flightService.create(flight);

        URI location = servletUriComponentBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newFlight.getId())
                .toUri();

        return ResponseEntity.created(location).body(newFlight);
    }

    @PutMapping("/id")
    public ResponseEntity<Flight> update(@PathVariable int id, @RequestBody Flight flight) {
        Optional<Flight> flightUpdated = flightService.update(id, flight);
        return flightUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Customer newFlight = flightService.create(flight);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newFlight.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newFlight);
                });
    }


}