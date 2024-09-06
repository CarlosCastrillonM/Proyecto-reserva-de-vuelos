package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Getter
@Setter
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

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

    @ManyToMany
    @JoinTable(
        name = "pasajeros",
        joinColumns = @JoinColumn(name = "id_cliente", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_vuelo", referencedColumnName = "id")
    )
    private List<Vuelo> vuelos;

    public void addvuelo(Vuelo vuelo) {
        this.vuelos.add(vuelo);
    }


}
