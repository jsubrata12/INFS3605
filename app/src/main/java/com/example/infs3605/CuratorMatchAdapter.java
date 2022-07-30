package com.example.infs3605;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CuratorMatchAdapter extends RecyclerView.Adapter<CuratorMatchViewHolder> {
    private ArrayList<CuratorProfile> listCurator;
    private ArrayList<CuratorProfile> filteredCuratorList;
    private ArrayList<String> test;
    private final CuratorMatchAdapter.OnItemClickListener listListener;
    Context context;


    public interface OnItemClickListener {
        void onClick(View view, String id);
    }

    public CuratorMatchAdapter(ArrayList<CuratorProfile> lists,  OnItemClickListener clickListener) {
        listCurator = lists;
        filteredCuratorList = lists;
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
        CuratorProfile curatorProfile = filteredCuratorList.get(position);
        holder.name.setText(curatorProfile.getCuratorName());
        holder.itemView.setTag(curatorProfile.getCuratorName());
        holder.countInvite.setText(Integer.toString(curatorProfile.getCount()));
        //holder.status.setText(Integer.toString(curatorProfile.getCount()));

    }

    @Override
    public int getItemCount() {
        return filteredCuratorList.size();
    }

    public void updateCount(int count){

    }

}

class CuratorMatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name, countInvite;
    private CuratorMatchAdapter.OnItemClickListener clickListener;


    public CuratorMatchViewHolder(@NonNull View itemView, CuratorMatchAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.curatorName);
        countInvite = itemView.findViewById(R.id.countInvite);
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, (String) view.getTag());
    }
}
