package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AirlineDto {
    private Integer id;
    private String name;
    private int code;
    private String origin;
    private List<Flight> flights;

    public AirlineDto(Integer id, String name, int code, String origin, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.origin = origin;
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
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
