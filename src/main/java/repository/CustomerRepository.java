package repository;

import com.example.eldorado.entidades.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface CustomerRepository extends JpaRepository <Customer, Integer> {
    @Query("SELECT cust FROM Customer cust WHERE cust.name = ?1")
    List<Customer> findByName(String name);
}