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
        holder.image.setImageResource(holder.itemView.getResources().getIdentifier(project.getImage(), "drawable", "com.example.infs3605"));
        holder.itemView.setTag(project.getProjectName());
        LocalDate localDate = LocalDate.now();

        int compareValue = localDate.compareTo(project.getEoiStart());
        int compareValue1 = localDate.compareTo(project.getFullAppStart());
        int compareValue2 = localDate.compareTo(project.getReviewStart());
        int compareValue3 = localDate.compareTo(project.getFinalists());
        int compareValue4 = localDate.compareTo(project.getVenturePitch());
        int compareValue5 = localDate.compareTo(project.getFinished());

        if(compareValue >= 0){
            holder.chipStatus.setText("EOI");
            holder.percent.setText("0%");
        }
        if(compareValue1 >= 0){
            holder.chipStatus.setText("Application");
            holder.bar.incrementProgressBy((int) 20);
            holder.percent.setText("20%");

        }
        if(compareValue2 >= 0){
            holder.chipStatus.setText("Review & Curation");
            holder.bar.incrementProgressBy((int) 20);
            holder.percent.setText("40%");

        }
        if(compareValue3 >= 0){
            holder.chipStatus.setText("Finalists");
            holder.bar.incrementProgressBy((int) 20);
            holder.percent.setText("60%");

        }
        if(compareValue4 > 0){
            holder.chipStatus.setText("Event");
            holder.bar.incrementProgressBy((int) 20);
            holder.percent.setText("80%");
        }
        if(compareValue5 > 0){
            holder.chipStatus.setText("Finished");
            holder.bar.incrementProgressBy((int) 20);
            holder.percent.setText("100%");
        }
    }

    @Override
    public int getItemCount(){
        return listProject.size();
    }
}

class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name, percent;
    public Chip chipStatus;
    public ProgressBar bar;
    public ImageView image;
    private ProjectAdapter.OnItemClickListener clickListener;

    public ProjectViewHolder(@NonNull View itemView, ProjectAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.tvName);
        chipStatus = itemView.findViewById(R.id.projStatusChip);
        bar = itemView.findViewById(R.id.rvProgressBar);
        percent = itemView.findViewById(R.id.percentageTv);
        image = itemView.findViewById(R.id.listImage);
    }

    @Override
    public void onClick(View view){
        clickListener.onClick(view, (String) view.getTag());}
}