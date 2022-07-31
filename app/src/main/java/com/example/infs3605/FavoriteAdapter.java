package com.example.infs3605;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder> {
    private ArrayList<Task> mTasks;
    private RecyclerViewClickListener mListener;

    public FavoriteAdapter (ArrayList<Task> tasks, RecyclerViewClickListener listener) {
        mTasks = tasks;
        mListener = listener;
    }

    @NonNull
    @Override
    public FavoriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_to_action_row, parent, false);
        return new FavoriteViewHolder(view, mListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull FavoriteViewHolder holder, int position) {
        Task task = mTasks.get(position);

        holder.mTask.setText(task.getName());
        holder.mDueDate.setText(task.getDueFromNow());
        holder.itemView.setTag(task.getTaskId());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int taskId);
    }

    class FavoriteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTask, mDueDate;
        private ImageView mActionImage;
        private RecyclerViewClickListener mListener;

        public FavoriteViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            mTask = itemView.findViewById(R.id.taskTv);
            mDueDate = itemView.findViewById(R.id.dueDateTv);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, (int) view.getTag());
        }
    }
}

