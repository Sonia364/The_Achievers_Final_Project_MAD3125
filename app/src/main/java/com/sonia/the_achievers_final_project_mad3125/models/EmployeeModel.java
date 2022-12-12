package com.sonia.the_achievers_final_project_mad3125.models;

import java.io.Serializable;

public class EmployeeModel implements Serializable {
    private String id;
    private Employee employee;

    public EmployeeModel(String id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmployeeName(){
        return getEmployee().getName();
    }

    public String getEmployeeType(){
        return getEmployee().getType();
    }
}
