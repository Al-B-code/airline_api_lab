package com.example.airline_api.components;


import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    public DataLoader(){

    }



    @Override
    public void run(ApplicationArguments args) throws Exception {


        Flight tenerife = new Flight("Tenerife, Spain", 200, "10/12/23", "14:00");
        flightRepository.save(tenerife);

        Flight amsterdam = new Flight("Amsterdam, Netherlands", 250, "13/12/23", "20:00");
        flightRepository.save(amsterdam);

        Flight usa = new Flight("New York, USA", 250, "14/12/23", "07:00");
        flightRepository.save(usa);

        Flight paris = new Flight("Paris, France", 150, "06/12/23", "09:00");
        flightRepository.save(paris);


    }
}
