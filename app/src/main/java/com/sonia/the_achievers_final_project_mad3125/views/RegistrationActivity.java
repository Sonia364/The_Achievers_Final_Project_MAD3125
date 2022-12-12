package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationBarView;
import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.EmployeeViewModel;
import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityMainBinding;
import com.sonia.the_achievers_final_project_mad3125.models.Car;
import com.sonia.the_achievers_final_project_mad3125.models.Employee;
import com.sonia.the_achievers_final_project_mad3125.models.EmployeeModel;
import com.sonia.the_achievers_final_project_mad3125.models.Manager;
import com.sonia.the_achievers_final_project_mad3125.models.Motorcycle;
import com.sonia.the_achievers_final_project_mad3125.models.Programmer;
import com.sonia.the_achievers_final_project_mad3125.models.Tester;
import com.sonia.the_achievers_final_project_mad3125.models.Vehicle;
import com.sonia.the_achievers_final_project_mad3125.R;
import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityRegistrationBinding;

import java.util.ArrayList;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    EmployeeViewModel employeeViewModel;
    Vehicle vehicle;
    Employee employee;
    ActivityRegistrationBinding binding;
    String selectedVehicleType = "";
    String selectedSidecar = "";

    private static  String FIRSTNAME = "firstname";
    private static  String LASTNAME = "lastname";
    private static  String BIRTHYEAR = "birthyear";
    private String firstnameVal;
    private String lastnameVal;
    private String birthyearval;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        employeeViewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.empType.setAdapter(adapter);
        binding.empType.setOnItemSelectedListener(this);

        binding.typeCar.setOnClickListener(this);
        binding.typeMotorcycle.setOnClickListener(this);

        binding.cycleYes.setOnClickListener(this);
        binding.cycleNo.setOnClickListener(this);

        binding.btnRegister.setOnClickListener(
                v->{

                    if(binding.empFirstname.getText().toString().equals("")){
                        binding.empFirstname.setError("Please enter the first name");
                        binding.empFirstname.requestFocus();

                    }else if(binding.empLastname.getText().toString().equals("")){
                        binding.empLastname.setError("Please enter the last name");
                        binding.empLastname.requestFocus();

                    }
                    else if(binding.empBirthyear.getText().toString().equals("")){
                        binding.empBirthyear.setError("Please enter the Birth year");
                        binding.empBirthyear.requestFocus();
                    }
                    else if(binding.empSalary.getText().toString().equals("")){
                        binding.empSalary.setError("Please enter Employee salary");
                        binding.empSalary.requestFocus();
                    }
                    else if(binding.empOccupation.getText().toString().equals("")){
                        binding.empOccupation.setError("Please enter Occupation rate");
                        binding.empOccupation.requestFocus();
                    }
                    else if(binding.empId.getText().toString().equals("")){
                        binding.empId.setError("Please enter Employee id");
                        binding.empId.requestFocus();
                    }
                    else if(binding.empType.getSelectedItem().toString().equals("Choose a Type.."))
                    {
                        TextView errorText = (TextView)binding.empType.getSelectedView();
                        errorText.setError("");
                        errorText.setText("Please Choose Employee type");
                    }
                    else if(binding.vehicleModel.getText().toString().equals("")){
                        binding.vehicleModel.setError("Please select vehicle model");
                        binding.vehicleModel.requestFocus();
                    }
                    else if(binding.plateNumber.getText().toString().equals("")){
                        binding.plateNumber.setError("Please enter the Plate number");
                        binding.plateNumber.requestFocus();
                    }
                    else if(binding.chooseColor.getSelectedItem().toString().equals("Choose a color.."))
                    {
                        TextView errorText = (TextView)binding.chooseColor.getSelectedView();
                        errorText.setError("");
                        errorText.setText("Please Choose Vehicle Color");
                    }
                    else {

                        switch (selectedVehicleType) {
                            case "Car":
                                vehicle = new Car(binding.vehicleModel.getText().toString(), binding.plateNumber.getText().toString(), binding.chooseColor.getSelectedItem().toString(), binding.carType.getText().toString(), selectedVehicleType);
                                break;
                            case "Motorcycle":
                                vehicle = new Motorcycle(binding.vehicleModel.getText().toString(), binding.plateNumber.getText().toString(), binding.chooseColor.getSelectedItem().toString(), selectedSidecar, selectedVehicleType);
                                break;
                        }

                        switch (binding.empType.getSelectedItem().toString()) {
                            case "Manager":
                                employee = new Manager(binding.empFirstname.getText().toString(),
                                        Integer.parseInt(binding.empBirthyear.getText().toString()),
                                        Integer.parseInt(binding.empSalary.getText().toString()),
                                        Integer.parseInt(binding.empOccupation.getText().toString()),
                                        binding.empType.getSelectedItem().toString(),
                                        Integer.parseInt(binding.workTypeCount.getText().toString()),
                                        vehicle);
                                break;
                            case "Programmer":
                                employee = new Programmer(binding.empFirstname.getText().toString(),
                                        Integer.parseInt(binding.empBirthyear.getText().toString()),
                                        Integer.parseInt(binding.empSalary.getText().toString()),
                                        Integer.parseInt(binding.empOccupation.getText().toString()),
                                        Integer.parseInt(binding.workTypeCount.getText().toString()),
                                        binding.empType.getSelectedItem().toString(),
                                        vehicle);
                                break;
                            case "Tester":
                                employee = new Tester(binding.empFirstname.getText().toString(),
                                        Integer.parseInt(binding.empBirthyear.getText().toString()),
                                        Integer.parseInt(binding.empSalary.getText().toString()),
                                        Integer.parseInt(binding.empOccupation.getText().toString()),
                                        Integer.parseInt(binding.workTypeCount.getText().toString()),
                                        binding.empType.getSelectedItem().toString(),
                                        vehicle);
                                break;
                        }

                        EmployeeApplication.setList(new EmployeeModel(binding.empId.getText().toString(), employee));
                        System.out.println(EmployeeApplication.getList());
                        Intent intent = new Intent(RegistrationActivity.this, EmployeeDashboard.class);
                        startActivity(intent);
                    }

                });

    }

    @Override
    public void onClick(View view) {
        if(binding.typeCar.isChecked()){
            binding.carType.setVisibility(View.VISIBLE);
            binding.sideCarLayout.setVisibility(View.GONE);
            selectedVehicleType = "Car";
        }
        if(binding.typeMotorcycle.isChecked()) {
            binding.carType.setVisibility(View.GONE);
            binding.sideCarLayout.setVisibility(View.VISIBLE);
            selectedVehicleType = "Motorcycle";
        }

        if(binding.cycleYes.isChecked()){
            selectedSidecar = "Yes";
        }
        if(binding.cycleNo.isChecked()) {
            selectedSidecar = "No";
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (binding.empType.getSelectedItem().toString()){
            case "Manager":
                binding.workTypeCount.setVisibility(View.VISIBLE);
                binding.workTypeCount.setHint("#clients");
                break;
            case "Programmer":
                binding.workTypeCount.setVisibility(View.VISIBLE);
                binding.workTypeCount.setHint("#projects");
                break;
            case "Tester":
                binding.workTypeCount.setVisibility(View.VISIBLE);
                binding.workTypeCount.setHint("#bugs");
                break;
        }
    }
    private void displayFirstname(String digitString) {
        binding.empFirstname.setText(digitString);
    }
    private void displayLastname(String digitString) {
        binding.empLastname.setText(digitString);
    }
    private void displayBirthyear(String digitString) {
        binding.empBirthyear.setText(digitString);
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstnameVal = savedInstanceState.getString(FIRSTNAME);
        lastnameVal = savedInstanceState.getString(LASTNAME);
        birthyearval = savedInstanceState.getString(BIRTHYEAR);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        outState.putString(FIRSTNAME, binding.empFirstname.getText().toString());
        outState.putString(LASTNAME, binding.empLastname.getText().toString());
        outState.putString(BIRTHYEAR, binding.empBirthyear.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}