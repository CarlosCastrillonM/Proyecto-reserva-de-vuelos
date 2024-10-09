package com.example.eldorado.dto;

import com.example.eldorado.entity.Flight;

import java.time.LocalDate;
import java.util.List;

public class StopoverDto {
    private Integer id;
    private LocalDate stopoverTime;
    private List<Flight> flights;

    public StopoverDto(Integer id, LocalDate stopoverTime, List<Flight> flights) {
        this.id = id;
        this.stopoverTime = stopoverTime;
        this.flights = flights;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStopoverTime() {
        return stopoverTime;
    }

    public void setStopoverTime(LocalDate stopoverTime) {
        this.stopoverTime = stopoverTime;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public String toString() {
        return "StopoverDto{" +
               "id=" + id +
               ", stopoverTime=" + stopoverTime +
               ", flights=" + flights +
               '}';
    }
}
