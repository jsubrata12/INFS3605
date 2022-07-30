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

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class SDGAdapter extends RecyclerView.Adapter<SDGViewHolder>{
    private static final String TAG = "Tag";
    private final ArrayList<SDG> listSDG;
    private final SDGAdapter.OnItemClickListener listListener;

    public interface OnItemClickListener{
        void onClick(View view, String id);
    }

    public SDGAdapter(ArrayList<SDG> lists, SDGAdapter.OnItemClickListener clickListener){
        listSDG = lists;
        listListener = clickListener;
    }

    @NonNull
    @Override
    public SDGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sdg_list_row, parent, false);
        return new SDGViewHolder(view, listListener);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull SDGViewHolder holder, int position){
        SDG sdg = listSDG.get(position);
        holder.name.setText(sdg.getSdgName());

        Project project = new Project();
        ArrayList<Project> projects = project.getProject();
        double count = 0;
        double total = 0;

        DecimalFormat df = new DecimalFormat("###.#");

        for (Project s : projects) {
            if(s.isSdg1()){
                total++;
            }
            if (s.isSdg3()) {
                total++;
            }
            if(s.isSdg2()) {
                total++;
            }
            if(s.isSdg3()){
                total++;
            }
            if(s.isSdg4()){
                total++;
            }
            if(s.isSdg5()){
                total++;
            }
            if(s.isSdg6()){
                total++;
            }
            if(s.isSdg7()){
                total++;
            }
            if(s.isSdg8()){
                total++;
            }
            if(s.isSdg9()){
                total++;
            }
            if(s.isSdg10()){
                total++;
            }
            if(s.isSdg11()){
                total++;
            }
            if(s.isSdg12()){
                total++;
            }
            if(s.isSdg13()){
                total++;
            }
            if(s.isSdg14()){
                total++;
            }
            if(s.isSdg15()){
                total++;
            }
            if(s.isSdg16()){
                total++;
            }
            if(s.isSdg17()){
                total++;
            }

            if (sdg.getSdgName().equals("No Poverty") && s.isSdg1() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg_colour);


            }
            if (sdg.getSdgName().equals("Zero Hunger") && s.isSdg2() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg2_colour);
            }
            if (sdg.getSdgName().equals("Good Health and Well-being") && s.isSdg3() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg3_colour);
            }
            if (sdg.getSdgName().equals("Quality Education") && s.isSdg4() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg4_colour);

            }
            if (sdg.getSdgName().equals("Gender Equality") && s.isSdg5() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg5_colour);

            }
            if (sdg.getSdgName().equals(" Clean Water and Sanitation") && s.isSdg6() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg6_colour);

            }
            if (sdg.getSdgName().equals("Affordable and Clean Energy") && s.isSdg7() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg7_colour);

            }
            if (sdg.getSdgName().equals("Decent Work and Economic Growth") && s.isSdg8() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg8_colour);

            }
            if (sdg.getSdgName().equals("Industry, Innovation and Infrastructure") && s.isSdg9() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg9_colour);

            }
            if (sdg.getSdgName().equals("Reduced Inequalities") && s.isSdg10() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg10_colour);

            }
            if (sdg.getSdgName().equals("Sustainable Cities and Communities") && s.isSdg11() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg11_colour);

            }
            if (sdg.getSdgName().equals("Responsible Consumption and Production") && s.isSdg12() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg12_colour);

            }
            if (sdg.getSdgName().equals("Climate Action") && s.isSdg13() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg13_colour);

            }
            if (sdg.getSdgName().equals("Life Below Water") && s.isSdg14() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg14_colour);

            }
            if (sdg.getSdgName().equals("Life on Land") && s.isSdg15() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg15_colour);

            }
            if (sdg.getSdgName().equals("Peace, Justice and Strong Institutions") && s.isSdg16() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg16_colour);

            }
            if (sdg.getSdgName().equals("Partnerships for the Goals") && s.isSdg17() == true) {
                count++;
                holder.count.setText(df.format((count / total) * 100));
                holder.colour.setImageResource(R.drawable.circle_sdg17_colour);
            }
        }

        holder.itemView.setTag(sdg.getSdgName());
    }

    @Override
    public int getItemCount(){
        return listSDG.size();
    }
}

class SDGViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView name, count;
    public ImageView colour;
    private SDGAdapter.OnItemClickListener clickListener;

    public SDGViewHolder(@NonNull View itemView, SDGAdapter.OnItemClickListener listListener){
        super(itemView);
        this.clickListener = listListener;
        itemView.setOnClickListener(this);
        name = itemView.findViewById(R.id.sdgName);
        count = itemView.findViewById(R.id.sdgCount);
        colour = itemView.findViewById(R.id.colourCode);
    }

    @Override
    public void onClick(View view){
        clickListener.onClick(view, (String) view.getTag());}
}
