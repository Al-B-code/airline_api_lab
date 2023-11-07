package com.example.airline_api.dto;

public class FlightDTO {

    private String destination;

    private int capacity;

    private String departureDate;
    private String departureTime;

    //WIll not contain a passenger list because i want the addflight method inside of the services to create an empty list.


    public FlightDTO() {
    }


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
