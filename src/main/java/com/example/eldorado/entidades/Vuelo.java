package com.example.eldorado.entidades;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table (name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "origen")
    private String origen;

    @Column(name = "destino")
    private String destino;

    @Column(name = "fecha_salida")
    @Temporal (TemporalType.DATE)
    private LocalDate fechaSalida;

    @Column(name = "fecha_llegada")
    @Temporal (TemporalType.DATE)
    private LocalDate fechaLlegada;

    @Column(name = "duracion")
    private Duration duracion;

    @Column(name = "capacidad")
    private int capacidad;
}
