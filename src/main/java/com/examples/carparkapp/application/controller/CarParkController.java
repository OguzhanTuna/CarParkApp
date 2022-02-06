package com.examples.carparkapp.application.controller;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.dto.ParkStatusDto;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
//@ResponseBody
@RestController
@RequestMapping(path = "/carpark")
public class CarParkController {
    private final ICarParkService carParkService;
    //...

    //Constructor Injection.
    public CarParkController(ICarParkService carParkService)
    {
        this.carParkService = carParkService;
    }

    @RequestMapping(path = "/status", method = RequestMethod.GET)
    public ResponseEntity<List<ParkStatusDto>> getStatus()
    {
        List<ParkStatusDto> parkStatusDtoList = carParkService.status();

        return new ResponseEntity<List<ParkStatusDto>>(parkStatusDtoList, HttpStatus.OK);
    }

    @PostMapping(path = "/park")
    public ResponseEntity<String> includePark(@RequestBody IncludeParkDto parkDto)
    {
        String response = carParkService.includePark(parkDto);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/leave/{parkId}")
    public void leave(@PathVariable long parkId)
    {
        carParkService.leave(parkId);
    }
}