package com.examples.carparkapp.service;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.entity.Park;
import com.examples.carparkapp.mapper.IParkMapper;
import com.examples.carparkapp.repository.abstraction.ICarParkRepository;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import com.examples.exceptionlib.exceptionlib.util.FunctionalExceptionUtil;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Validated
public class CarParkService implements ICarParkService {
    private final ICarParkRepository carParkRepository;
    private final IParkMapper parkMapper;
    //...

    private List<ParkStatusDto> doWorkForParkStatusDtoList(Iterable<Park> entityIterable)
    {
        return StreamSupport.stream(entityIterable.spliterator(), false)
                .map(parkMapper::toParkStatusDto) //Method Reference
                .collect(Collectors.toList());
    }

    public String includeParkCallback(IncludeParkDto parkDto)
    {
        long availableParkSlot = carParkRepository.getAvailableParkId();

        if(availableParkSlot == 0) return "Garage is full";
        else carParkRepository.updateAvailableSlotForPark(availableParkSlot, parkDto.getPlate(), parkDto.getColor());

        return "Allocated " + availableParkSlot + " slot.";
    }

    public String leaveCallback(long parkId)
    {
        carParkRepository.updateSlotForLeaveByParkId(parkId);

        return "Emptied " + parkId + " slot.";
    }

    //Constructor Injection. No @Autowired annotation with Spring 4.3
    public CarParkService(ICarParkRepository carParkRepository, IParkMapper parkMapper)
    {
        this.carParkRepository = carParkRepository;
        this.parkMapper = parkMapper;
    }

    @Override
    public List<ParkStatusDto> status()
    {
        return FunctionalExceptionUtil
                .doWorkForServiceException(() -> this.doWorkForParkStatusDtoList(carParkRepository.findAll()),
                "Service Exception for 'STATUS' method");
    }

    @Override
    public String includePark(@NotNull @Valid @Validated(IncludeParkDto.class) IncludeParkDto parkDto)
    {
        return FunctionalExceptionUtil
                .doWorkForServiceException(() -> this.includeParkCallback(parkDto),
                        "Service Exception for 'INCLUDE PARK' method");
    }

    @Override
    public String leave(long parkId)
    {
        return FunctionalExceptionUtil
                .doWorkForServiceException(() -> this.leaveCallback(parkId),
                        "Service Exception for 'LEAVE' method");
    }
}
