package com.sonia.the_achievers_final_project_mad3125.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sonia.the_achievers_final_project_mad3125.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter implements Serializable {

    private ArrayList<EmployeeModel> employees;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;

    public EmployeeAdapter(@NonNull Context context, int resource, ArrayList<EmployeeModel> employees) {
        super(context, resource);
        this.employees = employees;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            v = layoutInflater.inflate(layoutResource, parent, false);

            TextView nameText= v.findViewById(R.id.empName);
            TextView typeText = v.findViewById(R.id.empRole);
            TextView idText = v.findViewById(R.id.empId);

            nameText.setText(employees.get(position).getEmployeeName());
            idText.setText(String.valueOf(employees.get(position).getId()));
            typeText.setText(employees.get(position).getEmployeeType());

        }
        return v;
    }
}