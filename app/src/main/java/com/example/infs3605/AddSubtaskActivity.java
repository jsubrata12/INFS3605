package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddSubtaskActivity extends AppCompatActivity {
    private TextView mTaskName;
    private EditText mSubtaskName;
    private Button mDoneButton;
    private Task task;
    private long subtaskCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subtask);
        setTitle("Add a new Subtask");

        mTaskName = findViewById(R.id.initTaskNameTv);
        mSubtaskName = findViewById(R.id.subtaskNameEt);
        mDoneButton = findViewById(R.id.doneBtn);

        Intent intent = getIntent();
        String taskId = intent.getStringExtra(TaskDetailActivity.EXTRA_MESSAGE);

        DatabaseReference referenceTask = FirebaseDatabase.getInstance().getReference("Task");
        referenceTask.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Task findTask = dataSnapshot.getValue(Task.class);
                    if (findTask.getTaskId() == Integer.parseInt(taskId)) {
                        mTaskName.setText(findTask.getName());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check that field is not empty
                if(mSubtaskName.getText().toString().equals("")) {
                    mSubtaskName.setError("Please enter the name of your subtask");
                }
                else {
                    String subtaskName = mSubtaskName.getText().toString();
                    DatabaseReference referenceSubtask = FirebaseDatabase.getInstance().getReference("Subtask");
                    referenceSubtask.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            subtaskCount = snapshot.getChildrenCount() + 1;
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    Subtask newSubtask = new Subtask(Integer.parseInt(taskId), (int) subtaskCount, subtaskName, false);
                    referenceSubtask.child("subtask" + subtaskCount).setValue(newSubtask);
                    Intent intent = new Intent(AddSubtaskActivity.this, TaskDetailActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}