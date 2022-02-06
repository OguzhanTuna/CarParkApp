package com.examples.carparkapp.service.abstraction;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.entity.Park;

import java.util.List;

public interface ICarParkService {
    //...

    List<ParkStatusDto> status();

    String includePark(IncludeParkDto parkDto);

    void leave(long parkId);

    Park save(Park park);
}
