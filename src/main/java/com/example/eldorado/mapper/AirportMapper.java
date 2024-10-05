package com.example.eldorado.mapper;

import com.example.eldorado.dto.AirportDto;
import com.example.eldorado.entity.Airport;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AirportMapper {
    AirportMapper INSTANCE = Mappers.getMapper(AirportMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "city", source = "city"),
        @Mapping(target = "country", source = "country"),
        @Mapping(target = "flights", source = "flights")
    })
    AirportDto toDto(Airport airport);

    @InheritInverseConfiguration
    Airport toEntity(AirportDto airportDto);
}
