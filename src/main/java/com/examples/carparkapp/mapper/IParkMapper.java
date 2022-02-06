package com.examples.carparkapp.mapper;

import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.entity.Park;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(implementationName = "ParkMapper", componentModel = "spring")
public interface IParkMapper {
    //...

    @Mapping(source = "parkId", target = "slot")
    ParkStatusDto toParkStatusDto(Park entity);

    @Mapping(source = "slot", target = "parkId")
    Park toParkEntity(ParkStatusDto dto);
}
