package com.examples.carparkapp.application.controller;

import com.examples.carparkapp.dto.IncludeParkDto;
import com.examples.carparkapp.exception.handler.CarParkAppApiError;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import com.examples.exceptionlib.exceptionlib.util.ExceptionUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    //Action method. (API, Handler method)
    @RequestMapping(path = "/status", method = RequestMethod.GET)
    public ResponseEntity<Object> getStatus()
    {
        //Business Operation
        return ExceptionUtil
                .subscribe(() -> new ResponseEntity<>(carParkService.status(), HttpStatus.OK),
                        ex -> new ResponseEntity<>(new CarParkAppApiError(HttpStatus.OK, "Error occured during 'status' subUrl", "Debug Message", "Rejected Value"), HttpStatus.OK));
    }

    @RequestMapping(path = "/entry", method = RequestMethod.GET)
    public String getEntryValueString(@RequestParam(name = "val") int val)
    {
        return "Entry Value: " + val + ".";
    }

    @PostMapping(path = "/park")
    public ResponseEntity<Object> includePark(@RequestBody IncludeParkDto parkDto)
    {
        return ExceptionUtil
                .subscribe(() -> new ResponseEntity<>(carParkService.includePark(parkDto), HttpStatus.OK),
                        ex -> new ResponseEntity<>(new CarParkAppApiError(HttpStatus.OK, "Error occured during 'park' subUrl", "Debug Message", "Rejected Value"), HttpStatus.OK));
    }

    @DeleteMapping(path = "/leave/{parkId}")
    public ResponseEntity<Object> leave(@PathVariable long parkId)
    {
        return ExceptionUtil
                .subscribe(() -> new ResponseEntity<>(carParkService.leave(parkId), HttpStatus.OK),
                        ex -> new ResponseEntity<>(new CarParkAppApiError(HttpStatus.OK, "Error occured during 'leave' subUrl", "Debug Message", "Rejected Value"), HttpStatus.OK));
    }
}