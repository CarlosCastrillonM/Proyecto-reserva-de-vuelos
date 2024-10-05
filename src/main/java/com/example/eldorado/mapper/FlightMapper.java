package com.example.eldorado.mapper;

import com.example.eldorado.dto.FlightDto;
import com.example.eldorado.entity.Flight;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "origin", source = "origin"),
        @Mapping(target = "destination", source = "destination"),
        @Mapping(target = "departureDate", source = "departureDate"),
        @Mapping(target = "arrivalDate", source = "arrivalDate"),
        @Mapping(target = "duration", source = "duration"),
        @Mapping(target = "capacity", source = "capacity"),
        @Mapping(target = "airline", source = "airline"),
        @Mapping(target = "customers", source = "customers"),
        @Mapping(target = "stopovers", source = "stopovers"),

    })
    FlightDto toDto(Flight flight);

    @InheritInverseConfiguration
    Flight toEntity(FlightDto flightDto);
}
