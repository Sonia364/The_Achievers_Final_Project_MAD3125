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

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter {

    private ArrayList<EmployeeModel> employees;
    private final LayoutInflater layoutInflater;
    onClick click;
    private final int layoutResource;

    public EmployeeAdapter(@NonNull Context context, int resource, ArrayList<EmployeeModel> employees, onClick click) {
        super(context, resource);
        this.employees = employees;
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
        this.click = click;
    }

    public void setData(ArrayList<EmployeeModel> employee){
        this.employees = employee;
        notifyDataSetChanged();
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
            LinearLayout parentAdapter = v.findViewById(R.id.item_adapter);

            nameText.setText(employees.get(position).getEmployeeName());
            idText.setText(String.valueOf(employees.get(position).getId()));
            typeText.setText(employees.get(position).getEmployeeType());
            parentAdapter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    click.click(position);
                }
            });


        }
        return v;

    }
    public  interface onClick{
        public void click(int position);
    }
}
