import com.example.eldorado.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import service.*
import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/customer/idCustomer")
    public ResponseEntity<Customer> getCustomerById(@pathVariable Integer id) {
        Optional<Customer> customer = customerService.find(id);

        if(customer.isPresent()) {
            return ResponseEntity.ok(customer.get());

        } else {
            return ResponseEntity.notFound();
        }
    }

    @PostMapping()
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws URISintaxException {
        Customer newCustomer = customerService.create(customer);

        URI location = servletUriComponentBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newCustomer.getId())
                .toUri();

        return ResponseEntity.created(location).body(newCustomer);
    }

    @PutMapping("/id")
    public ResponseEntity<Customer> update(@PathVariable int id, @RequestBody Customer customer) {
        Optional<Customer> customerUpdated = customerService.update(id, customer);
        return customerUpdated
                .map(c -> ResponseEntity.ok(c))
                .orElseGet(() -> {
                    Customer newCustomer = customerService.create(customer);
                    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newCustomer.getId())
                            .toUri();

                    return ResponseEntity.created(location).body(newCustomer);
                });
    }


}