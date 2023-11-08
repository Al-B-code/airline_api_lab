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
        Flight tenerife = new Flight("Tenerife, Spain", 200, "10/12/23", "14:00");
        flightRepository.save(tenerife);

        Flight amsterdam = new Flight("Amsterdam, Netherlands", 250, "13/12/23", "20:00");
        flightRepository.save(amsterdam);

        Flight usa = new Flight("New York, USA", 250, "14/12/23", "07:00");
        flightRepository.save(usa);

        Flight paris = new Flight("Paris, France", 150, "06/12/23", "09:00");
        flightRepository.save(paris);





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
        maisie.addFlight(paris);
        passengerRepository.save(maisie);

        jim.addFlight(usa);
        passengerRepository.save(jim);

        usa.addPassenger(alex);
        passengerRepository.save(alex);
        flightRepository.save(usa);


    }
}
