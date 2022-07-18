package com.example.infs3605;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

public class SDGActivity extends AppCompatActivity {
    TextView test;
    Project project = new Project();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdgs);

        test = findViewById(R.id.sdgPoint);

        ArrayList<Project> projects = project.getProject();

        int count = 0;

        for (Project s : projects) {
            if (s.isSdg15() == true) {
                count++;
                test.setText(Integer.toString(count));
            }
        }
    }
}