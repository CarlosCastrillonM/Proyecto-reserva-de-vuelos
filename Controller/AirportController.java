import com.example.eldorado.entidades.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import service.*
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/airport")
    public ResponseEntity<List<Airport>> getAllAirport(){
        return ResponseEntity.ok(airportService.findAll());
    }

    @GetMapping("/airport/idAirport")
    public ResponseEntity<Airport> getAirportById(@pathVariable Integer id) {
        Optional<Airport> airport = airportService.find(id);

        if(airport.isPresent()) {
            return ResponseEntity.ok(airport.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) throws URISintaxException {
        Airport newAirport = airportService.create(airport);

        URI location = servletUriComponentBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAirport.getId())
                .toUri();

        return ResponseEntity.created(location).body(newAirport);
    }

    @PutMapping("/id")
    public ResponseEntity<Airport> update(@PathVariable int id, @RequestBody Airport airport) {
        Optional<Airport> airportUpdated = airportService.update(id, airport);
        return airportUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Airport newAirport = airportService.create(airport);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newAirport.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newAirport);
                });
    }


}