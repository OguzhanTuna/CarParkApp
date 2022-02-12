package com.examples.carparkapp.service.abstraction;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface ICarParkService {
    //...

    List<ParkStatusDto> status();

    String includePark(@NotNull @Valid @Validated(IncludeParkDto.class) IncludeParkDto parkDto);

    String leave(long parkId);
}
