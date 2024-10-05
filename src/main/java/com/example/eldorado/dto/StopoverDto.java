package com.example.eldorado.dto;

import com.example.eldorado.entidades.Flight;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class StopoverDto {
    private Integer id;
    private LocalDate stopoverTime;
    private List<Flight> flights;

    public StopoverDto(Integer id, LocalDate stopoverTime, List<Flight> flights) {
        this.id = id;
        this.stopoverTime = stopoverTime;
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
