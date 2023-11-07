package com.example.airline_api.services;


import com.example.airline_api.dto.FlightDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {


    @Autowired
    FlightRepository flightRepository;

    public Flight addFlight(FlightDTO flightDTO){
        Flight flight = new Flight(
                flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime()
       );
       return flight;
   }

   public List<Flight> getAllFlights(){
        return flightRepository.findAll();
   }
}
