package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.R;

public class EmployeeDetail extends AppCompatActivity {

    String newString;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_detail2);

        //        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        newString= extras.getString("employee");
        TextView textView = findViewById(R.id.showDetail);
        textView.setText(newString);

    }

}