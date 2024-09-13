package service;

import com.example.eldorado.entidades.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository CustomerRepository) {
        this.customerRepository = CustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> find(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer create(Customer customer) {
        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setMail(customer.getMail());
        newCustomer.setReservations(customer.getReservations());
        newCustomer.setFlights(customer.getFlights());

        return customerRepository.save(newCustomer);
    }

    @Override
    public Optional<Customer> update(int id, Customer newCustomer) {
        return customerRepository.findById(id)
                .map(customerInDB -> {
                    customerInDB.setName(newCustomer.getName());
                    customerInDB.setLastName(newCustomer.getLastName());
                    customerInDB.setAddress(newCustomer.getAddress());
                    customerInDB.setPhone(newCustomer.getPhone());
                    customerInDB.setMail(newCustomer.getMail());
                    customerInDB.setReservations(newCustomer.getReservations());

                    return customerRepository.save(customerInDB);
                });
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findCustomerByName(String name) {
        return customerRepository.findByName(name);
    }

}
