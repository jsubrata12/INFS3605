package com.example.infs3605;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {
    private EditText mTaskName, mDateCreated, mDateDue, mDesc;
    private Button submitBtn;
    private String taskName;
    private LocalDate dueDate;
    private String description;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTaskName = findViewById(R.id.taskNameTv);
        mDateCreated = findViewById(R.id.dateCreatedTv);
        mDateDue = findViewById(R.id.dateDueTv);
        mDesc = findViewById(R.id.descEt);
        submitBtn = findViewById(R.id.completedButton);

        mDateCreated.setText(LocalDate.now().toString());
        mDateCreated.setEnabled(false);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitNewTask(view);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void submitNewTask(View view) {
        if(mTaskName.getText().toString().equals("")) {
            mTaskName.setError("Please enter the name of your task");
        }
        else {
            taskName = mTaskName.getText().toString();
        }

        if (mDateDue.getText().toString().equals("")) {
            mDateDue.setError("Please enter a valid date");
        }
        else {
            try {
                dueDate = LocalDate.parse(mDateDue.getText().toString());
            }
            catch (Exception e) {
                mDateDue.setError("Please enter date in format yyyy-mm-dd");
            }
        }

        if (mDesc.getText().toString().equals("")) {
            mDesc.setError("Please enter a description");
        }
        else {
            description = mDesc.getText().toString();
        }

        if (taskName != null && dueDate != null && mDesc != null) {
            ArrayList<Task> newTaskList = Task.addTask(new Task(taskName, LocalDate.now(), dueDate, description));

            Intent intent = new Intent(this, FavoriteFragment.class);
            startActivity(intent);
        }
    }
}