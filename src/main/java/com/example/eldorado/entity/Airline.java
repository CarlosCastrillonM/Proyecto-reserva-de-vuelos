package com.example.eldorado.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "airlines")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private int code;

    @Column(name = "country_origin")
    private String countryOrigin;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;

}
