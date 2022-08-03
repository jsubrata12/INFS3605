package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskDetailActivity extends AppCompatActivity {
    private Task task;
    private RecyclerView mRecyclerView;
    private TaskDetailAdapter mTaskDetailAdapter;
    private ImageButton mEditButton;
    private Button mCompletedButton, mDoneButton, mAddButton;
    private EditText mName, mDateCreated, mDateDue, mDesc;
    public static final String EXTRA_MESSAGE = "task detail";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        mDoneButton = findViewById(R.id.submitBtn);
        mDoneButton.setVisibility(View.GONE);

        Intent intent = getIntent();
        String taskId = intent.getStringExtra(FavoriteFragment.EXTRA_MESSAGE);

        DatabaseReference referenceTask = FirebaseDatabase.getInstance().getReference("Task");

        referenceTask.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Task searchTask = dataSnapshot.getValue(Task.class);
                    if (searchTask.getTaskId() == Integer.parseInt(taskId)) {
                        task = searchTask;
                        displayTaskDetails(task);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRecyclerView = findViewById(R.id.subTasksRv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        DatabaseReference referenceSubtask = FirebaseDatabase.getInstance().getReference("Subtask");

        TaskDetailAdapter.RecyclerViewClickListener listener = new TaskDetailAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int subtaskId) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Subtask");
                reference.child("subtask" + subtaskId).child("completed").setValue(true);
            }
        };


        ArrayList<Subtask> subtasks = new ArrayList<>();
        mTaskDetailAdapter = new TaskDetailAdapter(subtasks, listener);

        referenceSubtask.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                subtasks.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Subtask subtask = dataSnapshot.getValue(Subtask.class);
                    if (subtask.getTaskId() == task.getTaskId()) {
                        subtasks.add(subtask);
                    }

                }

                mTaskDetailAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mRecyclerView.setAdapter(mTaskDetailAdapter);



        mCompletedButton = findViewById(R.id.completedButton);
        mCompletedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Task");
                reference.child("task" + (task.getTaskId())).child("completed").setValue(true);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new FavoriteFragment());
                fragmentTransaction.commit();
            }
        });

        mEditButton = findViewById(R.id.editButton);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDoneButton.setVisibility(View.VISIBLE);
                mCompletedButton.setVisibility(View.GONE);
                mAddButton.setVisibility(View.GONE);
                mEditButton.setVisibility(View.GONE);
                editText();
            }
        });

        mAddButton = findViewById(R.id.addBtn);
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // launch add subtask activity
                Intent intent = new Intent(TaskDetailActivity.this, AddSubtaskActivity.class);
                intent.putExtra(EXTRA_MESSAGE, task.getTaskId()+"");
                startActivity(intent);
            }
        });
    }

    public void displayTaskDetails(Task task) {

        mName = findViewById(R.id.taskNameTv);
        mName.setText(task.getName());
        mName.setEnabled(false);
        mName.setTextColor(Color.parseColor("#929596"));

        mDateCreated = findViewById(R.id.dateCreatedTv);
        mDateCreated.setText(task.getDateCreated().toString());
        mDateCreated.setEnabled(false);
        mDateCreated.setTextColor(Color.parseColor("#929596"));

        mDateDue = findViewById(R.id.dateDueTv);
        mDateDue.setText(task.getDueDate().toString());
        mDateDue.setEnabled(false);
        mName.setTextColor(Color.parseColor("#929596"));

        mDesc = findViewById(R.id.descriptionTv);
        mDesc.setText(task.getDescription());
        mDesc.setEnabled(false);
        mName.setTextColor(Color.parseColor("#929596"));

    }

    public void editText() {
        mName.setEnabled(true);
        mName.setTextColor(Color.parseColor("#5B1C68"));

        mDateDue.setEnabled(true);
        mDateDue.setTextColor(Color.parseColor("#000000"));

        mDesc.setEnabled(true);
        mDesc.setTextColor(Color.parseColor("#000000"));


        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                String taskName = null, description = null;
                LocalDate dueDate = null;

                if(mName.getText().toString().equals("")) {
                    mName.setError("Please enter the name of your task");
                }
                else {
                    taskName = mName.getText().toString();
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
                    reference.child("task" + (task.getTaskId())).child("name").setValue(taskName);
                    reference.child("task" + (task.getTaskId())).child("dueDate").setValue(dueDate.toString());
                    reference.child("task" + (task.getTaskId())).child("description").setValue(description);
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }

            }
        });
    }
}