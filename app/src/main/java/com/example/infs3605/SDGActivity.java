package com.example.infs3605;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.chip.Chip;

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
    RecyclerView sdgRv;
    SDGAdapter sdgAdapter;
    Project project = new Project();
    SDG sdg = new SDG();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdgs);

        test = findViewById(R.id.sdgCount);
        sdgRv = findViewById(R.id.sdgRV);

        sdgRv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        sdgRv.setLayoutManager(layoutManager);

        SDGAdapter.OnItemClickListener clickListener = new SDGAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
            }
        };

        List<SDG> sdgList = SDG.getSDG();

        sdgAdapter = new SDGAdapter((ArrayList<SDG>) sdgList, clickListener);
        sdgRv.setAdapter(sdgAdapter);
    }
}