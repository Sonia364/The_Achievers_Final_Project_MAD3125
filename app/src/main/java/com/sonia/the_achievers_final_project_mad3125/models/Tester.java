package com.sonia.the_achievers_final_project_mad3125.models;

/**
 This class holds data for a Tester employee.
 */
public class Tester extends Employee {

    private final int GAIN_FACTOR_ERROR = 10;   // Gain Factor Error
    private int nbBugs = 0;

    /**
     * The Constructor sets the employee's name,
     * birth year, monthly Salary, rate, income, number of children.
     *
     * @param empName          The employee's name.
     * @param empBirthYear     The employee's birth year.
     * @param empMonthlySalary The employee's monthly salary.
     * @param empRate          The employee's rate.
     */
    public Tester(String empName, int empBirthYear, double empMonthlySalary, int empRate, int bugs, String empType, Vehicle vehicle) {
        super(empName,empBirthYear, empMonthlySalary, empRate, empType, vehicle);
        nbBugs = bugs;
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
        str = super.toString() + " and corrected " + nbBugs + " bugs."
                +"\nHis/Her estimated annual income is " + annualIncome();
        return str;
    }

    @Override
    public double annualIncome() {
        double yearlyIncome = super.annualIncome();
        double bonus = GAIN_FACTOR_ERROR * nbBugs;
        double annualIncome = yearlyIncome + bonus;
        return annualIncome;
    }


}