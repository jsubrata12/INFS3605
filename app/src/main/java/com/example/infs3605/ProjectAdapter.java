package com.example.infs3605;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

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

        Chip chip = new Chip(holder.group.getContext());
        Chip chip1 = new Chip(holder.group.getContext());
        Chip chip2 = new Chip(holder.group.getContext());
        Chip chip3 = new Chip(holder.group.getContext());
        Chip chip4 = new Chip(holder.group.getContext());
        Chip chip5 = new Chip(holder.group.getContext());
        Chip chip6 = new Chip(holder.group.getContext());
        Chip chip7 = new Chip(holder.group.getContext());
        Chip chip8 = new Chip(holder.group.getContext());
        Chip chip9 = new Chip(holder.group.getContext());
        Chip chip10 = new Chip(holder.group.getContext());
        Chip chip11 = new Chip(holder.group.getContext());
        Chip chip12 = new Chip(holder.group.getContext());
        Chip chip13 = new Chip(holder.group.getContext());
        Chip chip14 = new Chip(holder.group.getContext());
        Chip chip15 = new Chip(holder.group.getContext());
        Chip chip16 = new Chip(holder.group.getContext());

        SDG sdg = new SDG();
        ArrayList<SDG> sdgs = sdg.getSDG();

        for (SDG sd: sdgs){
            if(project.isSdg1() == true){
                chip.setText("No Poverty");
            }
            else if(project.isSdg1() == false){
                chip.setVisibility(View.GONE);
            }
            if(project.isSdg2() == true){
                chip1.setText("Zero Hunger");
            }
            else if(project.isSdg2() == false){
                chip1.setVisibility(View.GONE);
            }
            if(project.isSdg3() == true){
                chip2.setText("Good Health and Well-being");
            }
            else if(project.isSdg3() == false){
                chip2.setVisibility(View.GONE);
            }
            if(project.isSdg4() == true){
                chip3.setText("Quality Education");
            }
            else if(project.isSdg4() == false){
                chip3.setVisibility(View.GONE);
            }
            if(project.isSdg5() == true){
                chip4.setText("Gender Equality");
            }
            else if(project.isSdg5() == false){
                chip4.setVisibility(View.GONE);
            }
            if(project.isSdg6() == true){
                chip5.setText("Clean Water and Sanitation");
            }
            else if(project.isSdg6() == false){
                chip5.setVisibility(View.GONE);
            }
            if(project.isSdg7() == true){
                chip6.setText("Affordable and Clean Energy");
            }
            else if(project.isSdg7() == false){
                chip6.setVisibility(View.GONE);
            }
            if(project.isSdg8() == true){
                chip7.setText("Decent Work and Economic Growth");
            }
            else if(project.isSdg8() == false){
                chip7.setVisibility(View.GONE);
            }
            if(project.isSdg9() == true){
                chip8.setText("Industry, Innovation and Infrastructure");
            }
            else if(project.isSdg9() == false){
                chip8.setVisibility(View.GONE);
            }
            if(project.isSdg10() == true){
                chip9.setText("Reduced Inequalities");
            }
            else if(project.isSdg10() == false){
                chip9.setVisibility(View.GONE);
            }
            if(project.isSdg11() == true){
                chip10.setText("Sustainable Cities and Communities");
            }
            else if(project.isSdg11() == false){
                chip10.setVisibility(View.GONE);
            }
            if(project.isSdg12() == true){
                chip11.setText("Responsible Consumption and Production");
            }
            else if(project.isSdg12() == false){
                chip11.setVisibility(View.GONE);
            }
            if(project.isSdg13() == true){
                chip12.setText("Climate Action");
            }
            else if(project.isSdg13() == false){
                chip12.setVisibility(View.GONE);
            }
            if(project.isSdg14() == true){
                chip13.setText("Life Below Water");
            }
            else if(project.isSdg14() == false){
                chip13.setVisibility(View.GONE);
            }
            if(project.isSdg15() == true){
                chip14.setText("Life on Land");
            }
            else if(project.isSdg15() == false){
                chip14.setVisibility(View.GONE);
            }
            if(project.isSdg16() == true){
                chip15.setText("Peace, Justice and Strong Institutions");
            }
            else if(project.isSdg16() == false){
                chip15.setVisibility(View.GONE);
            }
            if(project.isSdg17() == true){
                chip16.setText("Partnerships for the Goals");
            }
            else if(project.isSdg17() == false){
                chip16.setVisibility(View.GONE);
            }

        }

        holder.group.addView(chip);
        holder.group.addView(chip1);
        holder.group.addView(chip2);
        holder.group.addView(chip3);
        holder.group.addView(chip4);
        holder.group.addView(chip5);
        holder.group.addView(chip6);
        holder.group.addView(chip7);
        holder.group.addView(chip8);
        holder.group.addView(chip9);
        holder.group.addView(chip10);
        holder.group.addView(chip11);
        holder.group.addView(chip12);
        holder.group.addView(chip13);
        holder.group.addView(chip14);
        holder.group.addView(chip15);
        holder.group.addView(chip16);

        holder.itemView.setTag(project.getProjectName());


    }

    @Override
    public int getItemCount(){
        return listProject.size();
    }
}

class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name;
    public ChipGroup group;
    private ProjectAdapter.OnItemClickListener clickListener;

    public ProjectViewHolder(@NonNull View itemView, ProjectAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.tvName);
        group = itemView.findViewById(R.id.testChipGroup);
    }

    @Override
    public void onClick(View view){
        clickListener.onClick(view, (String) view.getTag());}
}