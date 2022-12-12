package com.sonia.the_achievers_final_project_mad3125;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.io.Serializable;

public class EmployeeViewModel extends AndroidViewModel implements Serializable {
    public EmployeeViewModel(@NonNull Application application) {
        super(application);
    }
}
