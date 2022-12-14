package com.sonia.the_achievers_final_project_mad3125.models;

import java.io.Serializable;

/**
 The Vehicle class is an abstract class that holds
 general data about a vehicle. Classes representing
 specific types of vehicle should inherit from
 this class.
 */


public class Vehicle implements Serializable {

    private String make;
    private String plate;
    private String color;
    private String type;

    /**
     The Constructor sets the vehicle's make,
     plate, color, category.
     @param vehicleMake The vehicle's make.
     @param vehiclePlate The vehicle's plate.
     @param vehicleColor The vehicle's color.

     */

    public Vehicle(String vehicleMake, String vehiclePlate, String vehicleColor, String vehicleType){
        make = vehicleMake;
        plate = vehiclePlate;
        color = vehicleColor;
        type = vehicleType;
    }

    /**
     The toString method returns a String containing
     the vehicle's data.
     @return A reference to a String.
     */
    public String toString()
    {
        String str;
        str = "\nEmployee has a " + type + "\n"
                + "\t - make: " + make + "\n"
                + "\t - plate: " + plate + "\n"
                + "\t - color: " + color + "\n";
        return str;
    }

}
