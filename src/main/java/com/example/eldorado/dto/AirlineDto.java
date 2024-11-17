package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;

import java.util.List;

public class AirlineDto {
    private Integer id;
    private String name;
    private Integer code;
    private String origin;
    private List<Flight> flights;

    public AirlineDto(Integer id, String name, Integer code, String origin, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.origin = origin;
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "AirlineDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", code=" + code +
               ", countryOrigin='" + origin + '\'' +
               ", flights=" + flights +
               '}';
    }
}
