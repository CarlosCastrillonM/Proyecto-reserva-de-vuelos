package com.example.eldorado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_airport_origin")
    private Airport origin;

    @ManyToOne
    @JoinColumn(name = "id_airport_destination")
    private Airport destination;

    @Column(name = "departure_date")
    @Temporal(TemporalType.DATE)
    private LocalDate departureDate;

    @Column(name = "arrival_date")
    @Temporal(TemporalType.DATE)
    private LocalDate arrivalDate;

    @Column(name = "duration")
    private Duration duration;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "id_airline")
    private Airline airline;

    @ManyToMany(mappedBy = "flights")
    private List<Customer> customers;

    @ManyToMany
    @JoinTable(
            name = "stopover_x_flight",
            joinColumns = @JoinColumn(name = "id_flight", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_stopover", referencedColumnName = "id")
    )
    private List<Stopover> stopovers;
}
