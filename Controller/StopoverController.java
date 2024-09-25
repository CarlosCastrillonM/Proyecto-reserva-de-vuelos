import com.example.eldorado.entidades.Stopover;
import org.springframework.data.jpa.repository.JpaRepository;
import service.*
import java.util.List;

@RestController
@RequestMapping("/api/v6")
public class StopoverController {
    private final StopoverService stopoverService;

    public StopoverController(StopoverService stopoverService) {
        this.stopoverService = stopoverService;
    }

    @GetMapping("/stopover")
    public ResponseEntity<List<Stopover>> getAllStopover(){
        return ResponseEntity.ok(stopoverService.findAll());
    }

    @GetMapping("/stopover/idStopover")
    public ResponseEntity<Stopover> getReservationById(@pathVariable Integer id) {
        Optional<Stopover> stopover = stopoverService.find(id);

        if(stopover.isPresent()) {
            return ResponseEntity.ok(stopover.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Stopover> createReservation(@RequestBody Stopover stopover) throws URISintaxException {
        Stopover newStopover = stopover.create(stopover);

        URI location = servletUriComponentBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newStopover.getId())
                .toUri();

        return ResponseEntity.created(location).body(newStopover);
    }

    @PutMapping("/id")
    public ResponseEntity<Stopover> update(@PathVariable int id, @RequestBody Stopover stopover) {
        Optional<Stopover> stopoverUpdated = stopoverService.update(id, stopover);
        return stopoverUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Stopover newStopover = stopoverService.create(stopover);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newStopover.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newStopover);
                });
    }


}