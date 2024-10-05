package com.example.eldorado.dto;

import com.example.eldorado.entidades.Flight;
import com.example.eldorado.entidades.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CustomerDto {
    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String mail;
    private List<Reservation> reservations;
    private List<Flight> flights;

    public CustomerDto(Integer id, String name, String lastName, String address, String phone, String mail, List<Reservation> reservations, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.reservations = reservations;
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", lastName='" + lastName + '\'' +
               ", address='" + address + '\'' +
               ", phone='" + phone + '\'' +
               ", mail='" + mail + '\'' +
               ", reservations=" + reservations +
               ", flights=" + flights +
               '}';
    }
}
