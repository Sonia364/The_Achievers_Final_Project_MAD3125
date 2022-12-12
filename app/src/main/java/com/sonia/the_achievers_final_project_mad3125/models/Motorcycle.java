package com.sonia.the_achievers_final_project_mad3125.models;

public class Motorcycle extends Vehicle{

    private String sideCar;

    /**
     * The Constructor sets the vehicle's make,
     * plate, color, category, sideCar.
     *
     * @param vehicleMake     The vehicle's make.
     * @param vehiclePlate    The vehicle's plate.
     * @param vehicleColor    The vehicle's color.
     * @param vehicleSideCar The vehicle's sidecar.
     *
     */
    public Motorcycle(String vehicleMake, String vehiclePlate, String vehicleColor, String vehicleSideCar, String vehicleType) {
        super(vehicleMake, vehiclePlate, vehicleColor, vehicleType);
        sideCar = vehicleSideCar;
    }

    /**
     The toString method returns a String containing
     the motorcycle's data.
     @return A reference to a String.
     */
    @Override
    public String toString()
    {
        String str;
        String newStr;
        if (sideCar.equals("Yes")){
            newStr = "\t - with a sidecar\n ";
        }else{
            newStr = "\t - without a sidecar";
        }
        str = super.toString() + newStr;
        return str;
    }



}
