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
import java.util.Collections;
import java.util.Comparator;
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

        int counter = 0;

        for (CuratorProfile s : filtered) {
            if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg1() && project.isSdg1()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
                ;
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg2() && project.isSdg2()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg3() && project.isSdg3()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg4() && project.isSdg4()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg5() && project.isSdg5()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
                ;
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg6() && project.isSdg6()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg7() && project.isSdg7()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg8() && project.isSdg8()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg9() && project.isSdg9()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg10() && project.isSdg10()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg11() && project.isSdg11()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg12() && project.isSdg12()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg13() && project.isSdg13()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg14() && project.isSdg14()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg15() && project.isSdg15()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg16() && project.isSdg16()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
                System.out.println(counter);
            } else if (projName.equals("The Great Fashion Decarbonisation Opportunity") && s.isSdg17() && project.isSdg17()) {
                hs.add(new CuratorProfile(s.getCuratorName()));
            }

            curatorProfileList.clear();
            curatorProfileList.addAll(hs);

            cAdapter = new CuratorMatchAdapter((ArrayList<CuratorProfile>) curatorProfileList, clickListener);
            curatorRV.setAdapter(cAdapter);

        }



        for (CuratorProfile s : filtered) {
            if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg12() && project.isSdg12()) {
                    hs.add(new CuratorProfile(s.getCuratorName()));
                    System.out.println("Added" + s.getCuratorName());
                    //System.out.println(String.valueOf(count));
                }
                else if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg9() && project.isSdg9()) {
                        hs.add(new CuratorProfile(s.getCuratorName()));
                        System.out.println("Added 2" + s.getCuratorName());

                } else if (projName.equals("Bushfire Regeneration Challenge") && s.isSdg15() && project.isSdg15()) {
                    hs.add(new CuratorProfile(s.getCuratorName()));
                    System.out.println("Added 2" + s.getCuratorName());
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
        intent.putExtra(CuratorInviteActivity.PROJ_NAME, projName);
        startActivity(intent);
    }
}

