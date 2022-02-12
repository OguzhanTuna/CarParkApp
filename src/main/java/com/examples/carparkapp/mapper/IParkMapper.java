package com.examples.carparkapp.mapper;

import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.entity.Park;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(implementationName = "ParkMapper", componentModel = "spring")
public interface IParkMapper {
    //...

    //Alternative use
    //IParkMapper INSTANCE = Mappers.getMapper(IParkMapper.class);

    @Mapping(source = "parkId", target = "slot")
    ParkStatusDto toParkStatusDto(Park entity);

    @Mapping(source = "slot", target = "parkId")
    Park toParkEntity(ParkStatusDto dto);
}
