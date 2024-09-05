package com.example.eldorado.entidades;

import jakarta.persistence.*;
import org.springframework.data.annotation.Reference;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Table (name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Cliente cliente;

    @Column
    private String origen;

    @Column
    private String destino;

    @Column
    private LocalDate fechaSalida;

    @Column
    private LocalDate fechaLlegada;

    @Column
    private Duration duracion;
}
