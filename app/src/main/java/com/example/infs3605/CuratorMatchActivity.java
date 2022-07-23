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
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class CuratorMatchActivity extends AppCompatActivity {
    public static RecyclerView curatorRV;
    private CuratorMatchAdapter cAdapter;
    private TextView test;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curator_match);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Project project = Project.getProject(name);

        test = findViewById(R.id.count);

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

        if (name != null) {
            for (CuratorProfile s : filtered) {
                if (name.equals("Bushfire Regeneration Challenge") && s.isSdg12() &&
                        project.isSdg12()) {
                    //  hs.add(new CuratorProfile(s.getCuratorName()));
                    hs.add(new CuratorProfile(s.getCuratorName()));

                } else if (name.equals("Bushfire Regeneration Challenge") && s.isSdg9() &&
                        project.isSdg9()) {
                    //  hs.add(new CuratorProfile(s.getCuratorName()));
                    hs.add(new CuratorProfile(s.getCuratorName()));
                }

                curatorProfileList.clear();
                curatorProfileList.addAll(hs);

                cAdapter = new CuratorMatchAdapter((ArrayList<CuratorProfile>) curatorProfileList, clickListener);
                curatorRV.setAdapter(cAdapter);
            }
        }
    }

    public void launchDetailActivity(String name) {
        Intent intent = new Intent(CuratorMatchActivity.this, CuratorInviteActivity.class);
        intent.putExtra(CuratorInviteActivity.INTENT_MESSAGE, name);
        startActivity(intent);
    }
}
