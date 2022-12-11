package com.sonia.the_achievers_final_project_mad3125.models;

/**
 This class holds data for a Manager employee.
 */
public class Manager extends Employee {

    private final int GAIN_FACTOR_CLIENT = 500;
    private final int GAIN_FACTOR_TRAVEL = 100;
    private int travelDays;
    private int noOfClients;

    /**
     * The Constructor sets the employee's name,
     * birth year, monthly Salary, rate, income, number of children.
     *
     * @param empName          The employee's name.
     * @param empBirthYear     The employee's birth year.
     * @param empMonthlySalary The employee's monthly salary.
     * @param empRate          The employee's rate.
     */
    public Manager(String empName, int empBirthYear, double empMonthlySalary, int empRate, int mTravelDays, int mClients, Vehicle vehicle) {
        //this(empName, empBirthYear, empMonthlySalary, empRate, mTravelDays, mClients);
        super(empName, empBirthYear, empMonthlySalary, empRate, "Manager", vehicle);
        travelDays = mTravelDays;
        noOfClients = mClients;

    }

    public Manager(String empName, int empBirthYear, double empMonthlySalary, int empRate, int mTravelDays, int mClients) {
        this(empName, empBirthYear, empMonthlySalary, empRate, mTravelDays, mClients, null);
    }

    /**
     The toString method returns a String containing
     the employee's data.
     @return A reference to a String.
     */
    @Override
    public String toString()
    {
        String str;
        str = super.toString()+ " He/She travelled " + travelDays +" days and has brought " + noOfClients + " new clients."
                +"\nHis/Her estimated annual income is " + annualIncome();
        return str;
    }

    /**
     The override annualIncome method returns employee's final income.
     @return A reference to a double.
     */
    @Override
    public double annualIncome() {
        double yearlyIncome = super.annualIncome();
        double bonus = GAIN_FACTOR_CLIENT * noOfClients + GAIN_FACTOR_TRAVEL * travelDays;
        double annualIncome = yearlyIncome + bonus;
        return annualIncome;
    }

}