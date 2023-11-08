package com.example.airline_api.repositories;

import com.example.airline_api.dto.DestinationDTO;
import com.example.airline_api.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findFlightById(Long id);

    List<Flight> findFlightByDestination(String destination);

//    @Query("SELECT COUNT(pf) FROM passenger_flights pf INNER JOIN pf.flight flight WHERE flight.id = :flightId")
//    int countPassengerFlightsByFlightId(@Param("flightId") Long flightId);

//    @Query("SELECT COUNT(passenger_flights) FROM Flight f " +
//            "INNER JOIN f.passengers p " +
//            "WHERE f.id = :flightId")
//    int countPassengerFlightsByFlightId(@Param("flightId") Long flightId);


    @Query(value = "SELECT count(*) FROM passenger_flights " +
            "INNER JOIN flights ON passenger_flights.flight_id = flights.id " +
            "WHERE flight_id = :flightId", nativeQuery = true)
    int countPassengerFlightsForFlight(@Param("flightId") Long flightId);


}
