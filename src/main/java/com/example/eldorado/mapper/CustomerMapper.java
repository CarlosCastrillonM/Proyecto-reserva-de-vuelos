package com.example.eldorado.mapper;

import com.example.eldorado.dto.CustomerDto;
import com.example.eldorado.entidades.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
        @Mapping(target = "id", source = "id"),
        @Mapping(target = "name", source = "name"),
        @Mapping(target = "lastName", source = "lastName"),
        @Mapping(target = "address", source = "address"),
        @Mapping(target = "phone", source = "phone"),
        @Mapping(target = "mail", source = "mail"),
        @Mapping(target = "reservations", source = "reservations"),
        @Mapping(target = "flights", source = "flights")
    })
    CustomerDto toDto(Customer customer);

    @InheritInverseConfiguration
    Customer toEntity(CustomerDto customerDto);
}
