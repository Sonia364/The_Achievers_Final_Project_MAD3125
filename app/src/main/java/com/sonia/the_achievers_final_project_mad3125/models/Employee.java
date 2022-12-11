package com.sonia.the_achievers_final_project_mad3125.models; /**
 The Employee class is an abstract class that holds
 general data about an employee. Classes representing
 specific types of employees should inherit from
 this class.
 */
import java.time.YearMonth;
public class Employee
{

    public String name;
    private int birthYear;
    private double monthlySalary;

    private int rate = 100;
    private double income = 0.0;
    public String type;

    /**
     The Constructor sets the employee's name,
     birth year, monthly Salary, rate
     @param empName The employee's name.
     @param empBirthYear The employee's birth year.
     @param empMonthlySalary The employee's monthly salary.
     @param empRate The employee's rate.
     */
    public Employee(String empName, int empBirthYear, double empMonthlySalary, int empRate, String empType ){
        name = empName;
        birthYear = empBirthYear;
        monthlySalary = empMonthlySalary;
        rate = empRate;
        type = empType;
    }

    /**
     The age method.
     @return The age for the employee.
     */
    public int age(){
        int year = YearMonth.now().getYear();
        int calAge = year - birthYear;
        return calAge;
    }

    /**
     The toString method returns a String containing
     the employee's data.
     @return A reference to a String.
     */
    public String toString()
    {
        String str;
        str = "Name: " + name + ", a "+ type +"."
                + "\nAge: " + age() + " ";

        str += "\nOccupation rate: " + rate + "%";
        str += "\nAnnual Income: $"+annualIncome();
        return str;
    }

    /**
     The annualIncome method returns employee's annual income.
     @return A reference to a double.
     */
    public double annualIncome()
    {
        double yearlyIncome = 12 *  (monthlySalary * rate);
        return yearlyIncome;
    }

}