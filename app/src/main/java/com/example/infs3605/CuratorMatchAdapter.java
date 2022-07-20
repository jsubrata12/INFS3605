package com.example.infs3605;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CuratorMatchAdapter extends RecyclerView.Adapter<CuratorMatchViewHolder> {
    private final ArrayList<CuratorProfile> listCurator;
    private final CuratorMatchAdapter.OnItemClickListener listListener;


    public interface OnItemClickListener {
        void onClick(View view, String id);
    }

    public CuratorMatchAdapter(ArrayList<CuratorProfile> lists, CuratorMatchAdapter.OnItemClickListener clickListener) {
        listCurator = lists;
        listListener = clickListener;
    }

    @NonNull
    @Override
    public CuratorMatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.curator_list_row, parent, false);
        return new CuratorMatchViewHolder(view, listListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CuratorMatchViewHolder holder, int position) {
        CuratorProfile curatorProfile = listCurator.get(position);

        Project project = new Project();
        ArrayList<Project> projects = project.getProject();
        CuratorProfile cp = new CuratorProfile();
        ArrayList<CuratorProfile> cpList = cp.getCuratorProfile();


        for (Project s : projects) {
            if (s.isSdg12() == true && curatorProfile.isSdg12() == true) {
                holder.name.setText(curatorProfile.getCuratorName());
            }
        }
        holder.itemView.setTag(curatorProfile.getCuratorName());
    }

    public void removeItem(int position) {
        listCurator.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return listCurator.size();
    }
}

class CuratorMatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name;
    private CuratorMatchAdapter.OnItemClickListener clickListener;


    public CuratorMatchViewHolder(@NonNull View itemView, CuratorMatchAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.curatorName);
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, (String) view.getTag());
    }
}
