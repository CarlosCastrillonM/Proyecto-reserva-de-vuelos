package com.example.eldorado.mapper;

import com.example.eldorado.dto.StopoverDto;
import com.example.eldorado.entity.Stopover;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StopoverMapper {
    StopoverMapper INSTANCE = Mappers.getMapper(StopoverMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "stopoverTime", source = "stopoverTime"),
        @Mapping(target = "flights", source = "flights")
    })
    StopoverDto toDto(Stopover stopover);

    @InheritInverseConfiguration
    Stopover toEntity(StopoverDto stopoverDto);
}
