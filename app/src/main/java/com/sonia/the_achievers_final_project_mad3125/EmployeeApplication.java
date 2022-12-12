package com.sonia.the_achievers_final_project_mad3125;

import android.app.Application;

import com.sonia.the_achievers_final_project_mad3125.models.EmployeeModel;

import java.util.ArrayList;

public class EmployeeApplication extends Application {
    static ArrayList<EmployeeModel> commonList;

    @Override
    public void onCreate() {
        super.onCreate();
        commonList = new ArrayList<>();
    }

    static public ArrayList<EmployeeModel> getList() {
        return commonList;
    }

    static public void setList(ArrayList<EmployeeModel> list) {
        commonList = list;
    }
}
