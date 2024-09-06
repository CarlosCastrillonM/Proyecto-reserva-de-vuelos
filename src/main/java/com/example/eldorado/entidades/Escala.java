package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "escalas")
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tiempo_escala")
    private LocalDate tiempoEscala;

    @ManyToMany(mappedBy = "escalas")
    private List<Vuelo> vuelos;
}
