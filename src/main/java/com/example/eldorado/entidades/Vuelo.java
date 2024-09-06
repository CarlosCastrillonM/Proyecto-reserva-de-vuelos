package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen")
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino")
    private Aeropuerto destino;

    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaSalida;

    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaLlegada;

    @Column(name = "duracion")
    private Duration duracion;

    @Column(name = "capacidad")
    private int capacidad;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @ManyToMany(mappedBy = "vuelos")
    private List<Cliente> clientes;

    @ManyToMany
    @JoinTable(
            name = "escala_x_vuelo",
            joinColumns = @JoinColumn(name = "id_vuelo", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_escala", referencedColumnName = "id")
    )
    private List<Escala> escalas;
}
