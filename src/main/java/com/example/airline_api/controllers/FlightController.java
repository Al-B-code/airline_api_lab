package com.example.airline_api.controllers;

import com.example.airline_api.dto.BookingDTO;
import com.example.airline_api.dto.DestinationDTO;
import com.example.airline_api.dto.FlightDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping(value = "/destination")
    public ResponseEntity<List<Flight>> getAllFlightsByDestination(@RequestBody DestinationDTO destinationDTO){
        return new ResponseEntity<>(flightService.getAllFlightsByDestination(destinationDTO), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){

        return new ResponseEntity<>(flightService.getFlightById(id), HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody FlightDTO flightDTO){
        Flight savedFlight = flightService.addFlight(flightDTO); // make sure to save the flight in the FlightService.
        return new ResponseEntity<>(savedFlight, HttpStatus.OK);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@RequestBody BookingDTO bookingDTO, @PathVariable Long id){
        Flight flight = flightService.addPassengerToFlight(bookingDTO, id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity cancelFlight(@PathVariable Long id, @RequestBody BookingDTO bookingDTO){
        return new ResponseEntity(flightService.removePassengerFromFlight(bookingDTO, id), HttpStatus.OK);
    }



}
