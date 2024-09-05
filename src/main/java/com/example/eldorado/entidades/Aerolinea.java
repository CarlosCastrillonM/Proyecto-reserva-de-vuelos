package com.example.eldorado.entidades;

import jakarta.persistence.*;

import java.time.Duration;

@Entity
@Table (name = "aerolineas")
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private int codigo;

    @Column
    private String paisOrigen;
}
