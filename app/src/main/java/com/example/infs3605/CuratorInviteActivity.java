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
    public static final String PROJ_NAME = "test";
    private static final String TAG = "tag";
    TextView tv, result;
    Button inviteBtn;
    CuratorProjectStatusDatabase cpsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_curator);

        tv = findViewById(R.id.curatorInviteName);
        inviteBtn = findViewById(R.id.inviteBtn);
        result = findViewById(R.id.curatorResult);

        Intent intent = getIntent();
        String curatorID = intent.getStringExtra(INTENT_MESSAGE);
        String projectID = intent.getStringExtra(PROJ_NAME);
        CuratorProfile cp = CuratorProfile.getCuratorProfile(curatorID);
        Project proj = Project.getProject(projectID);

        if (cp != null && proj !=null) {
            tv.setText(cp.getCuratorName());
        }

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

            }
            });

        new Thread() {
            @Override
            public void run() {
                cpsDB = CuratorProjectStatusDatabase.getInstance(CuratorInviteActivity.this);
                List<CuratorProjectStatus> list = cpsDB.curatorProjectStatusDao().getAll();
                Log.d("Testing...", String.valueOf(list));

            }
        }.start();



        inviteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        Executors.newSingleThreadExecutor().execute(new Runnable() {
                            @Override
                            public void run() {
                                cpsDB = CuratorProjectStatusDatabase.getInstance(CuratorInviteActivity.this);
                                List<CuratorProjectStatus> cpsList = cpsDB.curatorProjectStatusDao().getUser(cp.getCuratorName());
                                System.out.println(cpsList);

                                int index = 0;

                                //prints points in the log
                                List<CuratorProjectStatus> getAll = cpsDB.curatorProjectStatusDao().getAll();
                                for (CuratorProjectStatus cc : getAll) {
                                    Log.d("Testing.. User", String.valueOf(+index + ": " + "User: " + cc.getCuratorName() + " " + cc.getProjectName()
                                            + " " + cc.getProjectStatus()));
                                }
                                cpsDB.curatorProjectStatusDao().insertOrUpdate(new CuratorProjectStatus(cp.getCuratorName(), proj.getProjectName(), "Invited"));
                                for (CuratorProjectStatus c : cpsList) {
                                    cpsDB.curatorProjectStatusDao().setStatus(cp.getCuratorName(), proj.getProjectName(), "Invited");
                                    Log.d(TAG, "Completed in Status Database");
                                }

                                }
                            });

                        }
                });

            }
        });
    }
}
