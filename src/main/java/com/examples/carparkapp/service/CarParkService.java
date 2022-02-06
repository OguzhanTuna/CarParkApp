package com.examples.carparkapp.service;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.entity.Park;
import com.examples.carparkapp.mapper.IParkMapper;
import com.examples.carparkapp.repository.abstraction.ICarParkRepository;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
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

    //Constructor Injection. No @Autowired annotation with Spring 4.3
    public CarParkService(ICarParkRepository carParkRepository, IParkMapper parkMapper)
    {
        this.carParkRepository = carParkRepository;
        this.parkMapper = parkMapper;
    }

    @Override
    public List<ParkStatusDto> status()
    {
        Iterable<Park> parkList = carParkRepository.findAll();

        return this.doWorkForParkStatusDtoList(parkList);
    }

    @Override
    @Transactional
    public String includePark(IncludeParkDto parkDto)
    {
        long availableParkSlot = carParkRepository.getAvailableParkId();

        if(availableParkSlot == 0) return "Garage is full";
        else carParkRepository.updateAvailableSlotForPark(availableParkSlot, parkDto.getPlate(), parkDto.getColor());

        return "Allocated " + availableParkSlot + " slot.";
    }

    @Override
    @Transactional
    public void leave(long parkId)
    {
        carParkRepository.updateAvailableSlotForLeave(parkId);
    }

    @Override
    public Park save(Park park)
    {
        return carParkRepository.save(park);
    }
}
