package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(
        name = "passenger",
        joinColumns = @JoinColumn(name = "id_customer", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_flight", referencedColumnName = "id")
    )
    private List<Flight> flights;

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }


}
