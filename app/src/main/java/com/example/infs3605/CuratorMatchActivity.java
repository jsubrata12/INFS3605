package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CuratorMatchActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "hello";
    private RecyclerView curatorRV;
    private CuratorMatchAdapter cAdapter;
    private ArrayList<CuratorProfile> listCurator = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curator_match);

        Intent intent = getIntent();
        String name = intent.getStringExtra("curator");

        // Link the RecyclerView to its xml item and set LayoutManager
        curatorRV = findViewById(R.id.curatorRV);
        curatorRV.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        curatorRV.setLayoutManager(layoutManager);

        CuratorMatchAdapter.OnItemClickListener clickListener = new CuratorMatchAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
            }
        };

        List<CuratorProfile> curatorProfileList = CuratorProfile.getCuratorProfile();

        cAdapter = new CuratorMatchAdapter((ArrayList<CuratorProfile>) curatorProfileList, clickListener);
        curatorRV.setAdapter(cAdapter);


    }

    public void test() {
        listCurator.clear();

        ArrayList<CuratorProfile> updatedList = new ArrayList<>();

        Project project = new Project();
        ArrayList<Project> projects = project.getProject();
        CuratorProfile cp = new CuratorProfile();
        ArrayList<CuratorProfile> cpList = cp.getCuratorProfile();

        for (Project s : projects) {
            for (CuratorProfile cc : cpList) {
                if (s.isSdg12() == true && cc.isSdg12() == true) {
                    updatedList.add(CuratorProfile.getCuratorProfile(cc.getCuratorName()));
                }
                listCurator.addAll(updatedList);
                cAdapter.notifyDataSetChanged();
            }
        }

    }

}
