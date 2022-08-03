package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddTaskActivity extends AppCompatActivity {
    private EditText mTaskName, mDateCreated, mDateDue, mDesc;
    private Button submitBtn;
    private String taskName;
    private LocalDate dueDate;
    private String description;
    private long taskIdCount;

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

        if (taskName != null && dueDate != null && description != null) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Task");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    taskIdCount = snapshot.getChildrenCount() + 1;
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            Task newTask = new Task((int) taskIdCount, taskName, dueDate.toString(), LocalDate.now().toString(), description);
            reference.child("task" + taskIdCount).setValue(newTask);
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new FavoriteFragment());
            fragmentTransaction.commit();
        }
    }
}