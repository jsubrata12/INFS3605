package com.example.infs3605;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ProjectDetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "hello";
    TextView test, name;
    private CuratorProfileDatabase curatorProfileDatabase;
    private Project project = new Project();
    CuratorProfile curatorProfile = new CuratorProfile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        test = findViewById(R.id.curatorTest);
        name = findViewById(R.id.projectNameTv);

        SDG sdg = new SDG();
        ArrayList<SDG> sdgs = sdg.getSDG();

        Intent intent = getIntent();
        String projectID = intent.getStringExtra(INTENT_MESSAGE);
        Project project = Project.getProject(projectID);

        ArrayList<CuratorProfile> cp = curatorProfile.getCuratorProfile();

        if (project != null) {
            name.setText(project.getProjectName());
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                  //  curatorProfileDatabase = CuratorProfileDatabase.getInstance(ProjectDetailActivity.this);
                    for (CuratorProfile curatorProfile : cp) {
                        TextView[] textView = new TextView[cp.size()];

                        LinearLayout rl = (LinearLayout) findViewById(R.id.linear);

                        if (project.isSdg11() == true) {
                            for (int i = 0; i < cp.size(); i++) {
                                //rl.addView(textView[i]);
                                final TextView rowTextView = new TextView(ProjectDetailActivity.this);

                                // set some properties of rowTextView or something
                                rowTextView.setText(curatorProfile.getCuratorName());

                                // add the textview to the linearlayout
                                rl.addView(rowTextView);

                                // save a reference to the textview for later
                                textView[i] = rowTextView;


                            }
                        }
                    }
                }
            });



            }
        }
    }
