package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityMainBinding;
import com.sonia.the_achievers_final_project_mad3125.models.Car;
import com.sonia.the_achievers_final_project_mad3125.models.EmployeeModel;
import com.sonia.the_achievers_final_project_mad3125.models.Manager;
import com.sonia.the_achievers_final_project_mad3125.models.Programmer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static  String USERNAME = "username";
    private static  String PASSWORD = "password";
    private String usernameVal;
    private String passwordVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (savedInstanceState != null){
            String usernameString = String.valueOf(savedInstanceState.getString(USERNAME));
            String passwordString = String.valueOf(savedInstanceState.getString(PASSWORD));
            displayUsername(usernameString);
            displayPassword(passwordString);
        }

        binding.btnLogin.setOnClickListener(
                v-> {
                    if (binding.username.getText().toString().equals("")) {
                        binding.username.setError("Please enter username");
                        binding.username.requestFocus();
                        return;

                    }
                    if (binding.password.getText().toString().equals("")) {
                        binding.password.setError("Please enter your Password");
                        binding.password.requestFocus();
                        return;

                    }

                    if (binding.username.getText().toString().equals("admin") && binding.password.getText().toString().equals("admin")) {
                        setDummyData();
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

    private void displayUsername(String digitString) {
        binding.username.setText(digitString);
    }
    private void displayPassword(String digitString) {
        binding.password.setText(digitString);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        usernameVal = savedInstanceState.getString(USERNAME);
        passwordVal = savedInstanceState.getString(PASSWORD);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString(USERNAME, binding.username.getText().toString());
        outState.putString(PASSWORD, binding.password.getText().toString());
        super.onSaveInstanceState(outState);
    }

    public void setDummyData(){
        EmployeeApplication.getList().clear();
        EmployeeApplication.getList().add(new EmployeeModel("emp1",new Manager("Rabia",
                1995,
                2000,
                20,
                "Manager",
                20,
                new Car("Honda",
                        "1234",
                        "Red",
                        "Sports",
                        "Car"
                ))));

        EmployeeApplication.getList().add(new EmployeeModel("emp2",new Programmer("Abhi",
                1985,
                2000,
                20,
                12,
                "Programmer",
                new Car("Honda",
                        "1234",
                        "Red",
                        "Sports",
                        "Car"
                ))));
    }
}