package com.example.infs3605;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SolutionsActivity extends AppCompatActivity {
    SolutionsAdapter sAdapter;
    RecyclerView solutionsRV;
    public static final String PROJ_NAME = "test";
    public static final String CURATOR_NAME = "hello";
    String projName;
    String curName;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solutions);

        Intent intent = getIntent();
        projName = intent.getStringExtra(PROJ_NAME);
        Project project = Project.getProject(projName);
        curName = intent.getStringExtra(CURATOR_NAME);
        CuratorProfile cp = CuratorProfile.getCuratorProfile(curName);

        System.out.println(cp.getCuratorName());

        // Link the RecyclerView to its xml item and set LayoutManager
        solutionsRV = findViewById(R.id.solutionsRV);
        solutionsRV.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        solutionsRV.setLayoutManager(layoutManager);

        SolutionsAdapter.OnItemClickListener clickListener = new SolutionsAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchDetailActivity(id);
            }
        };

        ArrayList<Solutions> solutionsArrayList = Solutions.getSolution();
        solutionsArrayList.clear();

        Solutions s = new Solutions();
        ArrayList<Solutions> filtered = s.getSolution();
        HashSet<Solutions> hs = new HashSet<Solutions>();


        for (Solutions sol : filtered) {
            if (projName.equals("The Great Fashion Decarbonisation Opportunity")) {
                hs.add(new Solutions(sol.getSolutionName(), sol.getDesc(), sol.getNeedsList()));
            }

            solutionsArrayList.clear();
            solutionsArrayList.addAll(hs);

            sAdapter = new SolutionsAdapter((ArrayList<Solutions>) solutionsArrayList, SolutionsActivity.this, clickListener);
            solutionsRV.setAdapter(sAdapter);
            }
        }

        public void launchDetailActivity (String name){
            Intent intent = new Intent(SolutionsActivity.this, CuratorMatchActivity.class);
            intent.putExtra(CuratorMatchActivity.SOLUTION_NAME, name);
            startActivity(intent);
        }
}
