package com.example.infs3605;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashSet;

public class CuratorMatchActivity extends AppCompatActivity {
    public static RecyclerView curatorRV;
    private CuratorMatchAdapter cAdapter;
    private TextView test;
    private String projName;
    private String curName;
    public static final String PROJ_NAME = "test";
    public static final String CURATOR_NAME = "hello";
    private static final String TAG = "tag";
    CuratorCountDatabase curatorCountDatabase;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curator_match);

        Intent intent = getIntent();
        projName = intent.getStringExtra(PROJ_NAME);
        Project project = Project.getProject(projName);
        curName = intent.getStringExtra(CURATOR_NAME);
        CuratorProfile curator = CuratorProfile.getCuratorProfile(curName);


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

        int count = 0;
        int[] arr = new int[17];

        for (CuratorProfile s : filtered) {
                if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg12() && project.isSdg12()) {
                    hs.add(new CuratorProfile(s.getCuratorName()));
                    System.out.println("Added" + s.getCuratorName());
                    //System.out.println(String.valueOf(count));
                }
                else if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg9() && project.isSdg9()) {
                        hs.add(new CuratorProfile(s.getCuratorName()));
                        System.out.println("Added 2" + s.getCuratorName());
                        System.out.println(String.valueOf(count));


            } else if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg15() && project.isSdg15()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
                System.out.println("Added 2" + s.getCuratorName());
                System.out.println(String.valueOf(count));
            }


            curatorProfileList.clear();
            curatorProfileList.addAll(hs);

            cAdapter = new CuratorMatchAdapter((ArrayList<CuratorProfile>) curatorProfileList, clickListener);
            curatorRV.setAdapter(cAdapter);
        }

        SDG sdg = new SDG();
        ArrayList<SDG> sdgArrayList = sdg.getSDG();

    }

    public void launchDetailActivity(String name) {
        Intent intent = new Intent(CuratorMatchActivity.this, CuratorInviteActivity.class);
        intent.putExtra(CuratorInviteActivity.INTENT_MESSAGE, name);
        intent.putExtra(CuratorInviteActivity.PROJ_NAME, projName);
        startActivity(intent);
    }
}

