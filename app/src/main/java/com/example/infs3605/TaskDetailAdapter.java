package com.example.infs3605;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskDetailAdapter extends RecyclerView.Adapter<TaskDetailAdapter.TaskDetailViewHolder >{
    private ArrayList<String> mSubTasks;
    private TaskDetailAdapter.RecyclerViewClickListener mListener;

    public TaskDetailAdapter (ArrayList<String> subtasks, TaskDetailAdapter.RecyclerViewClickListener listener) {
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
        String subTask = mSubTasks.get(position);

        holder.mCheckBox.setText(subTask);
        holder.itemView.setTag(subTask);
    }

    @Override
    public int getItemCount() {
        return mSubTasks.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int taskId);
    }

    class TaskDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
