package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;

import java.util.List;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
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
