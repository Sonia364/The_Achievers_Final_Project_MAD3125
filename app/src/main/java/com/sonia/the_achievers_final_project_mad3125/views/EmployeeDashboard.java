package com.sonia.the_achievers_final_project_mad3125.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sonia.the_achievers_final_project_mad3125.EmployeeApplication;
import com.sonia.the_achievers_final_project_mad3125.models.Car;
import com.sonia.the_achievers_final_project_mad3125.models.Manager;
import com.sonia.the_achievers_final_project_mad3125.models.Programmer;
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

        employeeAdapter = new EmployeeAdapter(this, R.layout.employee_layout, EmployeeApplication.getList());
        lv.setAdapter(employeeAdapter);

        lv.setOnItemClickListener(this);
        lv.setLongClickable(true);
        lv.setTextFilterEnabled(true);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                openLogoutDialog(position);
                return true;
            }
        });



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
            employeeAdapter = new EmployeeAdapter(this, R.layout.employee_layout, EmployeeApplication.getList());
            lv.setAdapter(employeeAdapter);
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

            employeeAdapter = new EmployeeAdapter(this, R.layout.employee_layout, tempArrayList);
            lv.setAdapter(employeeAdapter);

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



    void openLogoutDialog(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View view = layoutInflaterAndroid.inflate(R.layout.alert_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        Window window = alertDialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        WindowManager.LayoutParams lp = alertDialog.getWindow().getAttributes();
        alertDialog.getWindow().setGravity(Gravity.CENTER);
        alertDialog.getWindow().setAttributes(lp);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        AppCompatTextView edit = view.findViewById(R.id.edit);
        AppCompatTextView delete = view.findViewById(R.id.delete);
        edit.setOnClickListener(view1 -> {
           alertDialog.dismiss();
            Intent yourIntent = new Intent(EmployeeDashboard.this, RegistrationActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("employee", EmployeeApplication.getList().get(position));
            b.putInt("employeeIndex", position);
            yourIntent.putExtras(b);
            startActivity(yourIntent);

        });
        delete.setOnClickListener(view1 -> {
            alertDialog.dismiss();
            EmployeeApplication.getList().remove(position);
            employeeAdapter.notifyDataSetChanged();

        });
        alertDialog.show();
    }

}