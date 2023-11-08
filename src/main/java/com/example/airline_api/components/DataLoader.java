package com.example.airline_api.components;


import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightService flightService;

    public DataLoader(){

    }



    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Create flights
        Flight middayTenerife = new Flight("Tenerife, Spain", 200, LocalDate.of(2023,10,10), LocalTime.of(9,30 ));
        flightRepository.save(middayTenerife);

        Flight nightTenerife = new Flight("Tenerife, Spain", 200, LocalDate.of(2023,10,10), LocalTime.of(21,0 ));
        flightRepository.save(nightTenerife);

        Flight amsterdam = new Flight("Amsterdam, Netherlands", 250, LocalDate.of(2023,10,10), LocalTime.of(5,0 ));
        flightRepository.save(amsterdam);

        Flight usa = new Flight("New York, USA", 250, LocalDate.of(2023,12,12), LocalTime.of(9,0 ));
        flightRepository.save(usa);

        Flight paris = new Flight("Paris, France", 150, LocalDate.of(2023,10,10), LocalTime.of(20,30 ));
        flightRepository.save(paris);

        Flight testPassengerLimit = new Flight("Location", 5, LocalDate.of(2023,10,10), LocalTime.of(15,30 ));





        //create passengers
        Passenger bob = new Passenger("Bob", "Bob@email.com");
        passengerRepository.save(bob);

        Passenger jim = new Passenger("Jim", "Jim@email.com");
        passengerRepository.save(jim);

        Passenger alex = new Passenger("Alex", "Alex@email.com");
        passengerRepository.save(alex);

        Passenger maisie = new Passenger("Maisie", "Maisie@email.com");
        passengerRepository.save(maisie);




        //add passenger to flights
        usa.addPassenger(alex);
        flightRepository.save(usa);

        paris.addPassenger(jim);
        flightRepository.save(paris);

        middayTenerife.addPassenger(bob);
        middayTenerife.addPassenger(jim);
        middayTenerife.addPassenger(alex);
        flightRepository.save(middayTenerife);

        testPassengerLimit.addPassenger(maisie);
        flightRepository.save(testPassengerLimit);




    }
}
