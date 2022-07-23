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
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CuratorInviteActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "hello";
    private static final String TAG = "tag";
    TextView tv;
    Button inviteBtn;
    CuratorProjectStatusDatabase cpsDB;
    Project project = new Project();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_curator);

        tv = findViewById(R.id.curatorInviteName);
        inviteBtn = findViewById(R.id.inviteBtn);

        Intent intent = getIntent();
        String curatorID = intent.getStringExtra(INTENT_MESSAGE);
        CuratorProfile cp = CuratorProfile.getCuratorProfile(curatorID);

        ArrayList<Project> projectArrayList = project.getProject();

        if (cp != null) {
            tv.setText(cp.getCuratorName());
        }

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                cpsDB = CuratorProjectStatusDatabase.getInstance(CuratorInviteActivity.this);

            }
            });



        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                for (Project p : projectArrayList) {
                                    cpsDB = CuratorProjectStatusDatabase.getInstance(CuratorInviteActivity.this);
                                    cpsDB.curatorProjectStatusDao().setStatus("Invited", cp.getCuratorName(), p.getProjectName());
                                    Log.d(TAG, "Completed in Status Database");
                                }

                                    List<CuratorProjectStatus> list = cpsDB.curatorProjectStatusDao().getAll();
                                    int index = 0;
                                    for (CuratorProjectStatus cps : list) {
                                        Log.d("Testing...", String.valueOf(+index + "STATUS: " + cps.getCuratorName() + " " + cps.getProjectName() + " " + cps.getProjectStatus()));
                                    }
                                }
                            });

                        }
                });

            }
        });
    }
}
