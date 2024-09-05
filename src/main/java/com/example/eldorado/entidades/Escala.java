package com.example.eldorado.entidades;

import jakarta.persistence.*;

@Entity
@Table (name = "escalas")
public class Escala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}
