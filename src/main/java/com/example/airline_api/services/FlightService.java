package com.example.airline_api.services;


import com.example.airline_api.dto.BookingDTO;
import com.example.airline_api.dto.FlightDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {


    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public Flight addFlight(FlightDTO flightDTO){
        Flight flight = new Flight(
                flightDTO.getDestination(),
                flightDTO.getCapacity(),
                flightDTO.getDepartureDate(),
                flightDTO.getDepartureTime()
       );
        flightRepository.save(flight);
        return flight;
   }

   public List<Flight> getAllFlights(){
        return flightRepository.findAll();
   }

   public Flight getFlightById(Long id){
        return flightRepository.findFlightById(id);
   }


   @Transactional
   public Flight addPassengerToFlight(BookingDTO bookingDTO, Long id){
        Flight flight = flightRepository.findFlightById(id);
        Passenger passenger = passengerRepository.findPassengerById(bookingDTO.getPassengerId());
        flight.addPassenger(passenger);
        passenger.addFlight(flight);
        return flight;
   }
}


