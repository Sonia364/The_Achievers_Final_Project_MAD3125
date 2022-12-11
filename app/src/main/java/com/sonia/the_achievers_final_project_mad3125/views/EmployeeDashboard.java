package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;

import com.sonia.the_achievers_final_project_mad3125.R;

public class EmployeeDashboard extends AppCompatActivity {

    Button addRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_dashboard);

        addRecord = findViewById(R.id.add_new);

        addRecord.setOnClickListener(
                v-> {
                    Intent intent = new Intent(EmployeeDashboard.this, RegistrationActivity.class);
                    startActivity(intent);
                });

    }
}