package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                    if (binding.username.getText().toString().equals("")) {
                        binding.username.setError("Please enter username");
                        binding.username.requestFocus();
                        return;
//
                    }
                    if (binding.password.getText().toString().equals("")) {
                        binding.password.setError("Please enter your Password");
                        binding.password.requestFocus();
                        return;

                    }

                    if (binding.username.getText().toString().equals("admin") && binding.password.getText().toString().equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, EmployeeDashboard.class);
                        startActivity(intent);

                    } else
                    {
                        if (!binding.username.getText().toString().equals("admin")){
                            binding.username.setError("Please provide valid username");
                            binding.username.setText("");
                            binding.password.requestFocus();
                            return;
                        }
                        else if(!binding.password.getText().toString().equals("admin")){
                            binding.password.setError("Please provide valid password");
                            binding.password.setText("");
                            binding.password.requestFocus();
                            return;
                        }
                        else{
                            binding.username.setError("Please provide valid username");
                            binding.username.setText("");
                            binding.password.requestFocus();
                            binding.password.setError("Please provide valid password");
                            binding.password.setText("");
                            return;
                        }
                    }
                });

    }


}