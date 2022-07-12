package com.example.infs3605;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ProjectActivity extends AppCompatActivity {
    private RecyclerView projRV;
    private ProjectAdapter pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        // Link the RecyclerView to its xml item and set LayoutManager
        projRV = findViewById(R.id.projectRV);
        projRV.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        projRV.setLayoutManager(layoutManager);

        ProjectAdapter.OnItemClickListener clickListener = new ProjectAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
            }
        };

        List<Project> projectList = Project.getProject();

        pAdapter = new ProjectAdapter((ArrayList<Project>) projectList, clickListener);
        projRV.setAdapter(pAdapter);

    }
}
