package com.example.infs3605;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder>{
    private static final String TAG = "Tag";
    private final ArrayList<Project> listProject;
    private final ProjectAdapter.OnItemClickListener listListener;

    public interface OnItemClickListener{
        void onClick(View view, String id);
    }

    public ProjectAdapter(ArrayList<Project> lists, ProjectAdapter.OnItemClickListener clickListener){
        listProject = lists;
        listListener = clickListener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_row, parent, false);
        return new ProjectViewHolder(view, listListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, int position){
        Project project = listProject.get(position);
        holder.name.setText(project.getProjectName());
        // If the topic boolean isCompleted is true, a completed icon ImageView is set Visible

        holder.itemView.setTag(project.getProjectName());
    }

    @Override
    public int getItemCount(){
        return listProject.size();
    }
}

class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name;
    private ProjectAdapter.OnItemClickListener clickListener;

    public ProjectViewHolder(@NonNull View itemView, ProjectAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.tvName);
    }

    @Override
    public void onClick(View view){
        clickListener.onClick(view, (String) view.getTag());}
}