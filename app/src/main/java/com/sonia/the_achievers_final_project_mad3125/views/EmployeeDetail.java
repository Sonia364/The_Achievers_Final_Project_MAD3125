package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.R;

public class EmployeeDetail extends AppCompatActivity {
    TextView main;
    String i;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail2);
        main = findViewById(R.id.main);
        i = getIntent().getStringExtra("key");
        main.setText("Name : " + EmployeeApplication.getList().get(Integer.parseInt(i)).getEmployeeName() + "\n"
                + "Type  : " + EmployeeApplication.getList().get(Integer.parseInt(i)).getEmployeeType() + "\n" + "Id : " + EmployeeApplication.getList().get(Integer.parseInt(i)).getId());
    }

}