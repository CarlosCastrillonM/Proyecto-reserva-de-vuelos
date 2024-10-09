package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;
import com.example.eldorado.entity.Reservation;

import java.util.List;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
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
