package com.example.infs3605;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executors;

public class CuratorMatchActivity extends AppCompatActivity {
    public static RecyclerView curatorRV;
    private CuratorMatchAdapter cAdapter;
    private TextView test;
    private String solName;
    private Button inviteBtn;
    public static final String SOLUTION_NAME = "test";
    public static final String CURATOR_NAME = "hello";
    private static final String TAG = "tag";
    CuratorProjectStatusDatabase cpsDB;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_curator_match);

        Intent intent = getIntent();
        solName = intent.getStringExtra(SOLUTION_NAME);
        Solutions solutions = Solutions.getSolution(solName);

        // Link the RecyclerView to its xml item and set LayoutManager
        curatorRV = findViewById(R.id.curatorRV);
        curatorRV.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        curatorRV.setLayoutManager(layoutManager);

        CuratorMatchAdapter.OnItemClickListener clickListener = new CuratorMatchAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchDetailActivity(id);
            }
        };

        ArrayList<CuratorProfile> curatorProfileList = CuratorProfile.getCuratorProfile();
        curatorProfileList.clear();

        CuratorProfile cp = new CuratorProfile();
        ArrayList<CuratorProfile> filtered = cp.getCuratorProfile();
        HashSet<CuratorProfile> hs = new HashSet<CuratorProfile>();

        for (CuratorProfile s : filtered) {
            if (solutions.isDesignThinking() && s.isDesignThinking()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isTechnology() && s.isTechnology()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isUserExperience() && s.isUserExperience()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isProjectManagement() && s.isProjectManagement()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isDesign() && s.isDesign()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isResearch() && s.isResearch()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isRiskAssessment() && s.isRiskAssessment()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isStrategy() && s.isStrategy()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isAnalysis() && s.isAnalysis()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isKnowledgeManagement() && s.isKnowledgeManagement()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (solutions.isInnovation() && s.isInnovation()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            }

            curatorProfileList.clear();
            curatorProfileList.addAll(hs);

            cAdapter = new CuratorMatchAdapter((ArrayList<CuratorProfile>) curatorProfileList, clickListener);
            curatorRV.setAdapter(cAdapter);

        }
        Collections.sort(curatorProfileList, new Comparator<CuratorProfile>() {
            @Override
            public int compare(CuratorProfile curatorProfile, CuratorProfile t1) {
                return curatorProfile.getCuratorName().compareToIgnoreCase(t1.getCuratorName());
            }
        });
        cAdapter.notifyDataSetChanged();
    }
    public void launchDetailActivity(String name) {
        Intent intent = new Intent(CuratorMatchActivity.this, CuratorInviteActivity.class);
        intent.putExtra(CuratorInviteActivity.INTENT_MESSAGE, name);
        intent.putExtra(CuratorInviteActivity.SOLUTION_NAME, solName);
        startActivity(intent);
    }
}
