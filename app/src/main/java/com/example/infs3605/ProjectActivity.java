package com.example.infs3605;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ProjectActivity extends AppCompatActivity {
    private RecyclerView projRV;
    private ProjectAdapter pAdapter;


    @RequiresApi(api = Build.VERSION_CODES.O)
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
                launchDetailActivity(id);
            }
        };

        List<Project> projectList = Project.getProject();

        pAdapter = new ProjectAdapter((ArrayList<Project>) projectList, ProjectActivity.this, clickListener);
        projRV.setAdapter(pAdapter);


    }

    public void launchDetailActivity(String name) {
        Intent intent = new Intent(ProjectActivity.this, ProjectDetailActivity.class);
        intent.putExtra(ProjectDetailActivity.INTENT_MESSAGE, name);
        startActivity(intent);
    }

    private void getData(){

    }


}
