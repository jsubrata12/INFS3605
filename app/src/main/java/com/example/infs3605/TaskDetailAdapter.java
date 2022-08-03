package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TaskDetailAdapter extends RecyclerView.Adapter<TaskDetailAdapter.TaskDetailViewHolder >{
    private ArrayList<Subtask> mSubTasks;
    private TaskDetailAdapter.RecyclerViewClickListener mListener;

    public TaskDetailAdapter (ArrayList<Subtask> subtasks, TaskDetailAdapter.RecyclerViewClickListener listener) {
        mSubTasks = subtasks;
        mListener = listener;
    }

    @NonNull
    @Override
    public TaskDetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_row, parent, false);
        return new TaskDetailAdapter.TaskDetailViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskDetailViewHolder holder, int position) {
        Subtask subTask = mSubTasks.get(position);

        holder.mCheckBox.setText(subTask.getName());
        holder.mCheckBox.setChecked(subTask.isCompleted());

        holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Subtask");
                reference.child("subtask" + subTask.getSubtaskId()).child("completed").setValue(b);
            }
        });
        holder.itemView.setTag(subTask.getTaskId());
    }

    @Override
    public int getItemCount() {
        return mSubTasks.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int taskId);
    }

    class TaskDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CheckBox mCheckBox;
        private TaskDetailAdapter.RecyclerViewClickListener mListener;

        public TaskDetailViewHolder(@NonNull View itemView, TaskDetailAdapter.RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            mCheckBox = itemView.findViewById(R.id.taskCheckBox);
        }
        @Override
        public void onClick(View view) {
            mListener.onClick(view, (int) view.getTag());
        }
    }
}
