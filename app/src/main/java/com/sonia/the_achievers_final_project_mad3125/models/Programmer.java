package com.sonia.the_achievers_final_project_mad3125.models;

/**
 This class holds data for a Programmer employee.
 */

public class Programmer  extends Employee  {

    private final int GAIN_FACTOR_PROJECTS = 200;
    private int noOfProjects;
    /**
     * The Constructor sets the employee's name,
     * birth year, monthly Salary, rate, income, number of children.
     *
     * @param empName          The employee's name.
     * @param empBirthYear     The employee's birth year.
     * @param empMonthlySalary The employee's monthly salary.
     * @param empRate          The employee's rate.
     */
    public Programmer(String empName, int empBirthYear, double empMonthlySalary, int empRate, int pOfProjects) {
        super(empName, empBirthYear, empMonthlySalary, empRate, "Programmer");
        noOfProjects = pOfProjects;
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
        str = super.toString() +"\nHe/She has completed "+ noOfProjects +" projects";
        return str;
    }

    /**
     The override annualIncome method returns employee's final income.
     @return A reference to a double.
     */
    @Override
    public double annualIncome() {
        double yearlyIncome = super.annualIncome();
        double bonus = GAIN_FACTOR_PROJECTS * noOfProjects;
        double annualIncome = yearlyIncome + bonus;
        return annualIncome;
    }

}