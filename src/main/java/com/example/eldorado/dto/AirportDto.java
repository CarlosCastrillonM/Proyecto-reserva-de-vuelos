package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AirportDto {
    private Integer id;
    private String name;
    private String city;
    private String country;
    private List<Flight> flights;

    public AirportDto(Integer id, String name, String city, String country, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "AirportDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", city='" + city + '\'' +
               ", country='" + country + '\'' +
               ", flights=" + flights +
               '}';
    }
}
