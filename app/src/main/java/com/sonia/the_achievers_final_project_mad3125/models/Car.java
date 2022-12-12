package com.sonia.the_achievers_final_project_mad3125.models;

public class Car extends Vehicle{

    private String carType;

    /**
     * The Constructor sets the vehicle's make,
     * plate, color, category, gear, type.x`x`
     *
     * @param vehicleMake     The vehicle's make.
     * @param vehiclePlate    The vehicle's plate.
     * @param vehicleColor    The vehicle's color.
     * @param vehicleCategory The vehicle's category.
     * @param vehicleType     The vehicle's car type.
     *
     */
    public Car(String vehicleMake, String vehiclePlate, String vehicleColor, String vehicleCategory, String vehicleType) {
        super(vehicleMake, vehiclePlate, vehicleColor, vehicleType);
        carType = vehicleCategory;
    }

    /**
     The toString method returns a String containing
     the car's data.
     @return A reference to a String.
     */
    @Override
    public String toString()
    {
        String str;

        str = super.toString()
                + "\t - Type: " + carType;
        return str;
    }

}
