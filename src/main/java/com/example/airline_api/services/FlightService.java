package com.example.airline_api.services;


import com.example.airline_api.dto.BookingDTO;
import com.example.airline_api.dto.DestinationDTO;
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


   // needs to remove a passenger from a flight as well as remove a flight from a passenger
   @Transactional
   public String removePassengerFromFlight(BookingDTO bookingDTO, Long flightId){
        Flight flight = getFlightById(flightId);
        Passenger passenger = passengerRepository.findPassengerById(bookingDTO.getPassengerId());
        flightRepository.deleteById(flightId);
        passengerRepository.deleteById(bookingDTO.getPassengerId());

        return String.format("%s removed from the %s flight to %s on %s",
                passenger.getName(),
                flight.getDepartureTime(),
                flight.getDestination(),
                flight.getDepartureDate());
   }

   public List<Flight> getAllFlightsByDestination(DestinationDTO destinationDTO){
        String destination = destinationDTO.getDestination();
        return flightRepository.findFlightByDestination(destination);
   }
}


