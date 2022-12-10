package com.sonia.the_achievers_final_project_mad3125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       binding.btnLogin.setOnClickListener(
                v-> {
                if (binding.email.getText().toString().equals("")) {
                    Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (binding.password.getText().toString().equals("")) {
                    Toast.makeText(this, "Please enter your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (binding.email.getText().toString().equals("admin") && binding.password.getText().toString().equals("admin")) {
                    Intent intent = new Intent(MainActivity.this, EmployeeDashboard.class);
                    startActivity(intent);

                }

        });

    }


}