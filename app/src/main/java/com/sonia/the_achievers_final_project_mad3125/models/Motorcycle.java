package com.sonia.the_achievers_final_project_mad3125.models;

public class Motorcycle extends Vehicle{

    private boolean sideCar;

    /**
     * The Constructor sets the vehicle's make,
     * plate, color, category, sideCar.
     *
     * @param vehicleMake     The vehicle's make.
     * @param vehiclePlate    The vehicle's plate.
     * @param vehicleColor    The vehicle's color.
     * @param vehicleCategory The vehicle's category.
     * @param vehicleSideCar The vehicle's category.
     *
     */
    public Motorcycle(String vehicleMake, String vehiclePlate, String vehicleColor, String vehicleCategory, boolean vehicleSideCar) {
        super(vehicleMake, vehiclePlate, vehicleColor, vehicleCategory, "Motorcycle");
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
        if (sideCar){
            newStr = "\t - With sidecar\n ";
        }else{
            newStr = "\t - Without sidecar";
        }
        str = super.toString() + newStr;
        return str;
    }



}
