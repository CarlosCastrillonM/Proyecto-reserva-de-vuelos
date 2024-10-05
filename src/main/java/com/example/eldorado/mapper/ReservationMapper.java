package com.example.eldorado.mapper;

import com.example.eldorado.dto.ReservationDto;
import com.example.eldorado.entidades.Reservation;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "customer", source = "customer")
    })
    ReservationDto toDto(Reservation reservation);

    @InheritInverseConfiguration
    Reservation toEntity(ReservationDto reservationDto);
}
