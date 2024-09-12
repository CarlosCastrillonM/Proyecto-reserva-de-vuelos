package com.example.eldorado.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "stopover")
public class Stopover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stopover_time")
    private LocalDate stopoverTime;

    @ManyToMany(mappedBy = "stopovers")
    private List<Flight> flights;
}
