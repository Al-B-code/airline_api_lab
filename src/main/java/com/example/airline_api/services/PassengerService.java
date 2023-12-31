package com.example.airline_api.services;

import com.example.airline_api.dto.PassengerDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    public Passenger addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = new Passenger(
                passengerDTO.getName(),
                passengerDTO.getEmail()
        );

        passengerRepository.save(passenger);
        return passenger;
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id){
        return passengerRepository.findPassengerById(id);
    }


}
