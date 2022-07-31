package com.example.infs3605;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class TaskDetailActivity extends AppCompatActivity {
    private Task task;
    private RecyclerView mRecyclerView;
    private TaskDetailAdapter mTaskDetailAdapter;
    private ImageButton mEditButton;
    private Button mDoneButton;
    private EditText mName, mDateCreated, mDateDue, mDesc;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        Intent intent = getIntent();
        String taskId = intent.getStringExtra(FavoriteFragment.EXTRA_MESSAGE);

        System.out.println(taskId);
        task = Task.findTask(taskId);
        displayTaskDetails(task);


        mRecyclerView = findViewById(R.id.subTasksRv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        TaskDetailAdapter.RecyclerViewClickListener listener = new TaskDetailAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int taskId) {
            }
        };

        mTaskDetailAdapter = new TaskDetailAdapter(task.getSubtasks(), listener);
        mRecyclerView.setAdapter(mTaskDetailAdapter);

        mEditButton = findViewById(R.id.editButton);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText();
            }
        });

        mDoneButton = findViewById(R.id.completedButton);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task.setCompleted(true);
            }
        });
    }

    public void displayTaskDetails(Task task) {

        mName = findViewById(R.id.taskNameTv);
        mName.setText(task.getName());
        mName.setEnabled(false);

        mDateCreated = findViewById(R.id.dateCreatedTv);
        mDateCreated.setText(task.getDateCreated().toString());
        mDateCreated.setEnabled(false);

        mDateDue = findViewById(R.id.dateDueTv);
        mDateDue.setText(task.getDueDate().toString());
        mDateDue.setEnabled(false);

        mDesc = findViewById(R.id.descriptionTv);
        mDesc.setText(task.getDescription());
        mDesc.setEnabled(false);

    }

    public void editText() {
        mName.setEnabled(true);
        mDateDue.setEnabled(true);
        mDesc.setEnabled(true);
    }
}