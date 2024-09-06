package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "aerolineas")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private int codigo;

    @Column(name = "pais_orgien")
    private String paisOrigen;

    @OneToMany(mappedBy = "aerolinea")
    private List<Vuelo> vuelos;

}
