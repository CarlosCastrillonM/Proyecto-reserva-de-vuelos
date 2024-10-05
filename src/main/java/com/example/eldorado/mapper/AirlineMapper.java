package com.example.eldorado.mapper;

import com.example.eldorado.dto.AirlineDto;
import com.example.eldorado.entity.Airline;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AirlineMapper {
    AirlineMapper INSTANCE = Mappers.getMapper(AirlineMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "code", source = "code"),
        @Mapping(target = "origin", source = "countryOrigin"),
        @Mapping(target = "flights", source = "flights"),
    })
    AirlineDto toDto(Airline airline);

    @InheritInverseConfiguration
    Airline toEntity(AirlineDto airlineDto);
}
