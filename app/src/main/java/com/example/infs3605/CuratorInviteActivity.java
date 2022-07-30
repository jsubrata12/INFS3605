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

import com.google.firestore.v1.CursorOrBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CuratorInviteActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "hello";
    public static final String SOLUTION_NAME = "test";
    private static final String TAG = "tag";
    TextView tv, result;
    Button inviteBtn;
    String curatorID;
    String solutionsID;
    CuratorCountDatabase curatorCountDatabase;
    CuratorProjectStatusDatabase cpsDB;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_curator);

        Intent intent = getIntent();
        String curatorID = intent.getStringExtra(INTENT_MESSAGE);
        String solutionID = intent.getStringExtra(SOLUTION_NAME);
        CuratorProfile cp = CuratorProfile.getCuratorProfile(curatorID);
        Solutions sol = Solutions.getSolution(solutionID);

        inviteBtn = findViewById(R.id.inviteBtn);
        tv = findViewById(R.id.curatorInviteName);

        if (cp != null && sol != null) {
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

        new Thread() {
            @Override
            public void run() {
                curatorInviteStatus();

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
                                cpsDB.curatorProjectStatusDao().insertOrUpdate(new CuratorProjectStatus(cp.getCuratorName(), sol.getSolutionName(), "Invited"));
                                for (CuratorProjectStatus c : cpsList) {
                                    cpsDB.curatorProjectStatusDao().setStatus(cp.getCuratorName(), sol.getSolutionName(), "Invited");
                                    //inviteBtn.setText("Test");
                                    Log.d(TAG, "Completed in Status Database");

                                }
                            }

                        });

                    }
                });

            }
        });
    }

    private void curatorCount() {
        CuratorCountDatabase curatorCountDatabase = CuratorCountDatabase.getInstance(CuratorInviteActivity.this);
        List<CuratorCount> curatorCountList = curatorCountDatabase.curatorCountDao().getUserCount(curatorID, solutionsID);
        for (CuratorCount curatorCount : curatorCountList) {
            result.setText(String.valueOf(curatorCount.getCount()));
        }
    }

    private void curatorInviteStatus() {
        CuratorProjectStatusDatabase cpsDatabase = CuratorProjectStatusDatabase.getInstance(CuratorInviteActivity.this);
        List<CuratorProjectStatus> curatorProjectStatusList = cpsDatabase.curatorProjectStatusDao().getUser(curatorID);
        for (CuratorProjectStatus cps : curatorProjectStatusList) {
            result.setText(String.valueOf(cps.getProjectStatus()));
        }
    }
}





