package com.example.infs3605;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder>{
    private static final String TAG = "Tag";
    private final ArrayList<Project> listProject;
    private final ProjectAdapter.OnItemClickListener listListener;
    Context context;

    public interface OnItemClickListener{
        void onClick(View view, String id);
    }

    public ProjectAdapter(ArrayList<Project> lists, Context context, ProjectAdapter.OnItemClickListener clickListener){
        listProject = lists;
        listListener = clickListener;
    }

    @NonNull
    @Override
    public ProjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_list_row, parent, false);
        return new ProjectViewHolder(view, listListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull ProjectViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Project project = listProject.get(position);
        holder.name.setText(project.getProjectName());
        holder.itemView.setTag(project.getProjectName());
        LocalDate localDate = LocalDate.now();

        int compareValue = localDate.compareTo(project.getWebsiteLive());
        int compareValue1 = localDate.compareTo(project.getFullAppStart());
        int compareValue2 = localDate.compareTo(project.getReviewStart());
        int compareValue3 = localDate.compareTo(project.getCurationStart());
        int compareValue4 = localDate.compareTo(project.getProjectListStart());
        int compareValue5 = localDate.compareTo(project.getFundingStart());

        if(compareValue >= 0){
            holder.chipStatus.setText("Website Live");
            holder.bar.incrementProgressBy(20);
        }
        if(compareValue1 >= 0){
            holder.chipStatus.setText("Application");
            holder.bar.incrementProgressBy(20);

        }
        if(compareValue2 >= 0){
            holder.chipStatus.setText("Review");
            holder.bar.incrementProgressBy(20);

        }
        if(compareValue3 >= 0){
            holder.chipStatus.setText("Curation");
            holder.bar.incrementProgressBy(20);

        }
        if(compareValue4 >= 0){
            holder.chipStatus.setText("List Published");
            holder.bar.incrementProgressBy(20);

        }
        if(compareValue5 >= 0){
            holder.chipStatus.setText("Funding");
            holder.bar.incrementProgressBy(20);

        }
    }

    @Override
    public int getItemCount(){
        return listProject.size();
    }
}

class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name;
    public Chip chipStatus;
    public ProgressBar bar;
    private ProjectAdapter.OnItemClickListener clickListener;

    public ProjectViewHolder(@NonNull View itemView, ProjectAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.tvName);
        chipStatus = itemView.findViewById(R.id.projStatusChip);
        bar = itemView.findViewById(R.id.rvProgressBar);
    }

    @Override
    public void onClick(View view){
        clickListener.onClick(view, (String) view.getTag());}
}