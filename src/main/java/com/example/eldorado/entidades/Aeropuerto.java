package com.example.eldorado.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "aeropuertos")
public class Aeropuerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "pais")
    private String pais;
}
