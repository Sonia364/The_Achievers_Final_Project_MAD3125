package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.views.EmployeeDetail;
import com.sonia.the_achievers_final_project_mad3125.models.Employee;
import com.sonia.the_achievers_final_project_mad3125.models.EmployeeAdapter;
import com.sonia.the_achievers_final_project_mad3125.models.EmployeeModel;
import com.sonia.the_achievers_final_project_mad3125.models.Vehicle;
import com.sonia.the_achievers_final_project_mad3125.R;
import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityEmployeeDashboardBinding;
import com.sonia.the_achievers_final_project_mad3125.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDashboard extends AppCompatActivity implements SearchView.OnQueryTextListener, Serializable, AdapterView.OnItemClickListener {
    private ActivityEmployeeDashboardBinding binding;
    ListView lv;
    EmployeeAdapter employeeAdapter;
    FloatingActionButton addRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        lv = binding.employeeListView;
        setContentView(binding.getRoot());

        if(EmployeeApplication.getList()  !=null && EmployeeApplication.getList().size()>0) {

            employeeAdapter = new EmployeeAdapter(this, R.layout.employee_layout, EmployeeApplication.getList());
            lv.setAdapter(employeeAdapter);
        }

        lv.setOnItemClickListener(this);
        lv.setTextFilterEnabled(true);



        addRecord = findViewById(R.id.add_new);

        addRecord.setOnClickListener(
                v-> {
                    Intent intent = new Intent(EmployeeDashboard.this, RegistrationActivity.class);
                    startActivity(intent);
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService( Context.SEARCH_SERVICE );
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_item_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        // this is your adapter that will be filtered
        if (TextUtils.isEmpty(newText))
        {
            employeeAdapter.setData(EmployeeApplication.getList());
        }
        else
        {
            int textLength = newText.length();
            ArrayList<EmployeeModel> tempArrayList = new ArrayList<>();
            for(EmployeeModel c: EmployeeApplication.getList()){
                if (textLength <= c.getEmployeeName().length()) {
                    if (c.getEmployeeName().toLowerCase().contains(newText.toLowerCase())) {
                        tempArrayList.add(c);
                    }
                }
                if (textLength <= c.getEmployeeType().length()) {
                    if (c.getEmployeeType().toLowerCase().contains(newText.toLowerCase())) {
                        tempArrayList.add(c);
                    }
                }
                if (textLength <= String.valueOf(c.getId()).length()) {
                    if (String.valueOf(c.getId()).contains(newText.toLowerCase())) {
                        tempArrayList.add(c);
                    }
                }
            }

            employeeAdapter.setData(tempArrayList);

        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String employee = EmployeeApplication.getList().get(position).getEmployee().toString();
        Intent intent = new Intent(EmployeeDashboard.this, EmployeeDetail.class);
        intent.putExtra("employee",employee);
        startActivity(intent);
    }
}