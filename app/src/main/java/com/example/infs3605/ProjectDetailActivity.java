package com.example.infs3605;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProjectDetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "hello";
    public static final String PROJECT_NAME = "test";
    public static final String CUR_NAME = "hello";
    TextView name, desc, completeDate;
    ChipGroup group;
    Button btn;
    ImageView image;
    ProgressBar progressBar;
    CuratorProfile curatorProfile = new CuratorProfile();
    SDG sdg = new SDG();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);

        group = findViewById(R.id.group);
        name = findViewById(R.id.projectNameTv);
        btn = findViewById(R.id.findCurators);
        desc = findViewById(R.id.descTv);
        completeDate = findViewById(R.id.completeDate);
        progressBar = findViewById(R.id.projectStatus);

        Chip chip = new Chip(ProjectDetailActivity.this);
        Chip chip1 = new Chip(ProjectDetailActivity.this);
        Chip chip2 = new Chip(ProjectDetailActivity.this);
        Chip chip3 = new Chip(ProjectDetailActivity.this);
        Chip chip4 = new Chip(ProjectDetailActivity.this);
        Chip chip5 = new Chip(ProjectDetailActivity.this);
        Chip chip6 = new Chip(ProjectDetailActivity.this);
        Chip chip7 = new Chip(ProjectDetailActivity.this);
        Chip chip8 = new Chip(ProjectDetailActivity.this);
        Chip chip9 = new Chip(ProjectDetailActivity.this);
        Chip chip10 = new Chip(ProjectDetailActivity.this);
        Chip chip11 = new Chip(ProjectDetailActivity.this);
        Chip chip12 = new Chip(ProjectDetailActivity.this);
        Chip chip13 = new Chip(ProjectDetailActivity.this);
        Chip chip14 = new Chip(ProjectDetailActivity.this);
        Chip chip15 = new Chip(ProjectDetailActivity.this);
        Chip chip16 = new Chip(ProjectDetailActivity.this);

        Intent intent = getIntent();
        String projectID = intent.getStringExtra(INTENT_MESSAGE);
        Project project = Project.getProject(projectID);

        ArrayList<CuratorProfile> cp = curatorProfile.getCuratorProfile();
        ArrayList<SDG> sdgs = sdg.getSDG();

        if (project != null) {
            name.setText(project.getProjectName());
            desc.setText(project.getDesc());
            completeDate.setText(String.valueOf(project.getVenturePitch()));

            for (SDG sd : sdgs) {
                if (project.isSdg1() == true) {
                    chip.setText("No Poverty");
                } else if (project.isSdg1() == false) {
                    chip.setVisibility(View.GONE);
                }
                if (project.isSdg2() == true) {
                    chip1.setText("Zero Hunger");
                } else if (project.isSdg2() == false) {
                    chip1.setVisibility(View.GONE);
                }
                if (project.isSdg3() == true) {
                    chip2.setText("Good Health and Well-being");
                } else if (project.isSdg3() == false) {
                    chip2.setVisibility(View.GONE);
                }
                if (project.isSdg4() == true) {
                    chip3.setText("Quality Education");
                } else if (project.isSdg4() == false) {
                    chip3.setVisibility(View.GONE);
                }
                if (project.isSdg5() == true) {
                    chip4.setText("Gender Equality");
                } else if (project.isSdg5() == false) {
                    chip4.setVisibility(View.GONE);
                }
                if (project.isSdg6() == true) {
                    chip5.setText("Clean Water and Sanitation");
                } else if (project.isSdg6() == false) {
                    chip5.setVisibility(View.GONE);
                }
                if (project.isSdg7() == true) {
                    chip6.setText("Affordable and Clean Energy");
                } else if (project.isSdg7() == false) {
                    chip6.setVisibility(View.GONE);
                }
                if (project.isSdg8() == true) {
                    chip7.setText("Decent Work and Economic Growth");
                } else if (project.isSdg8() == false) {
                    chip7.setVisibility(View.GONE);
                }
                if (project.isSdg9() == true) {
                    chip8.setText("Industry, Innovation and Infrastructure");
                } else if (project.isSdg9() == false) {
                    chip8.setVisibility(View.GONE);
                }
                if (project.isSdg10() == true) {
                    chip9.setText("Reduced Inequalities");
                } else if (project.isSdg10() == false) {
                    chip9.setVisibility(View.GONE);
                }
                if (project.isSdg11() == true) {
                    chip10.setText("Sustainable Cities and Communities");
                } else if (project.isSdg11() == false) {
                    chip10.setVisibility(View.GONE);
                }
                if (project.isSdg12() == true) {
                    chip11.setText("Responsible Consumption and Production");
                } else if (project.isSdg12() == false) {
                    chip11.setVisibility(View.GONE);
                }
                if (project.isSdg13() == true) {
                    chip12.setText("Climate Action");
                } else if (project.isSdg13() == false) {
                    chip12.setVisibility(View.GONE);
                }
                if (project.isSdg14() == true) {
                    chip13.setText("Life Below Water");
                } else if (project.isSdg14() == false) {
                    chip13.setVisibility(View.GONE);
                }
                if (project.isSdg15() == true) {
                    chip14.setText("Life on Land");
                } else if (project.isSdg15() == false) {
                    chip14.setVisibility(View.GONE);
                }
                if (project.isSdg16() == true) {
                    chip15.setText("Peace, Justice and Strong Institutions");
                } else if (project.isSdg16() == false) {
                    chip15.setVisibility(View.GONE);
                }
                if (project.isSdg17() == true) {
                    chip16.setText("Partnerships for the Goals");
                } else if (project.isSdg17() == false) {
                    chip16.setVisibility(View.GONE);
                }
            }
            group.addView(chip);
            group.addView(chip1);
            group.addView(chip2);
            group.addView(chip3);
            group.addView(chip4);
            group.addView(chip5);
            group.addView(chip6);
            group.addView(chip7);
            group.addView(chip8);
            group.addView(chip9);
            group.addView(chip10);
            group.addView(chip11);
            group.addView(chip12);
            group.addView(chip13);
            group.addView(chip14);
            group.addView(chip15);
            group.addView(chip16);

            LocalDate localDate = LocalDate.now();

            int compareValue = localDate.compareTo(project.getEoiStart());
            int compareValue1 = localDate.compareTo(project.getFullAppStart());
            int compareValue2 = localDate.compareTo(project.getReviewStart());
            int compareValue3 = localDate.compareTo(project.getFinalists());
            int compareValue4 = localDate.compareTo(project.getVenturePitch());
            int compareValue5 = localDate.compareTo(project.getFinished());

            if(compareValue >= 0){

            }
            if(compareValue1 >= 0){
                progressBar.incrementProgressBy(20);


            }
            if(compareValue2 >= 0){
                progressBar.incrementProgressBy(20);

            }
            if(compareValue3 >= 0){
                progressBar.incrementProgressBy(20);


            }
            if(compareValue4 > 0){
                progressBar.incrementProgressBy(20);

            }
            if(compareValue5 > 0){
                progressBar.incrementProgressBy(20);

            }

            if(compareValue5 > 0){
                btn.setVisibility(View.GONE);
            }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ProjectDetailActivity.this, SolutionsActivity.class);
                    intent.putExtra(SolutionsActivity.PROJ_NAME, project.getProjectName());
                    for (CuratorProfile curatorProfile : cp) {
                        intent.putExtra(SolutionsActivity.CURATOR_NAME, curatorProfile.getCuratorName());
                    }
                    startActivity(intent);
                }
            });
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("project");
                String result1 = data.getStringExtra("curName");

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }
}

