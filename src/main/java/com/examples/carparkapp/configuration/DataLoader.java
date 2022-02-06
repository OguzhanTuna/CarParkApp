package com.examples.carparkapp.configuration;

import com.examples.carparkapp.entity.Park;
import com.examples.carparkapp.service.abstraction.ICarParkService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.IntStream;

@Configuration
public class DataLoader {
    private ICarParkService carParkService;
    //...

    //Constructor Injection.
    public DataLoader(ICarParkService carParkService)
    {
        this.carParkService = carParkService;
    }

    @Bean
    public ApplicationRunner getRunnerForInitializationParkData()
    {
        return (args) -> {
            IntStream.range(0, 10)
                    .forEach(i -> carParkService.save(Park.builder().setStatus("EMPTY").build()));
        };
    }
}
