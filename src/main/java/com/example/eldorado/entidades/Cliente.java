package com.example.eldorado.entidades;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table (name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;
}
