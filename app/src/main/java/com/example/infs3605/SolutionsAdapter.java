package com.example.infs3605;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;

import java.time.LocalDate;
import java.util.ArrayList;

public class SolutionsAdapter extends RecyclerView.Adapter<SolutionsViewHolder>{
    private static final String TAG = "Tag";
    private final ArrayList<Solutions> solutionsList;
    private final SolutionsAdapter.OnItemClickListener listListener;
    Context context;

    public interface OnItemClickListener{
        void onClick(View view, String id);
    }

    public SolutionsAdapter(ArrayList<Solutions> lists, Context context, SolutionsAdapter.OnItemClickListener clickListener){
        solutionsList = lists;
        listListener = clickListener;
    }

    @NonNull
    @Override
    public SolutionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.solutions_list_row, parent, false);
        return new SolutionsViewHolder(view, listListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SolutionsViewHolder holder, int position) {
        Solutions solutions = solutionsList.get(position);
        holder.solutionsName.setText(solutions.getSolutionName());
        holder.descr.setText(solutions.getDesc());
        holder.needs.setText(solutions.getNeedsList());

        holder.itemView.setTag(solutions.getSolutionName());

    }

    @Override
    public int getItemCount(){
        return solutionsList.size();
    }
}

class SolutionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView solutionsName, descr, needs;
    public Button inviteBtn;
    private SolutionsAdapter.OnItemClickListener clickListener;

    public SolutionsViewHolder(@NonNull View itemView, SolutionsAdapter.OnItemClickListener listListener) {
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        solutionsName = itemView.findViewById(R.id.solutionsTv);
        descr = itemView.findViewById(R.id.solutionsDescTv);
        needs = itemView.findViewById(R.id.solutionsNeedsTv);
    }

    @Override
    public void onClick(View view) {
        clickListener.onClick(view, (String) view.getTag());
    }
}

