package com.example.infs3605;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Simple example of ListAdapter for using with Folding Cell
 * Adapter holds indexes of unfolded elements for correct work with default reusable views behavior
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ItemViewHolder>{

    private Context context;
    private ArrayList<Comment> commentArrayList;

    public CommentAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Comment> list){
        commentArrayList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_row,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
    Comment comments = commentArrayList.get(position);
    // Instantiate the elements of the listview on CommentActivity and put them on their respective layout element
    holder.tvTitle.setText(comments.getTitle());
    holder.tvContent.setText(comments.getContent());
    holder.imageView.setImageResource(comments.getImageView());
    holder.sentimentScore.setText(comments.getSentimentScore());
    holder.foldingCell.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Folding cell by default is closed unless clicked on
            holder.foldingCell.toggle(false);
        }
    });
    }

    @Override
    public int getItemCount() {
        return commentArrayList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private FoldingCell foldingCell;
        private TextView tvTitle,tvContent, sentimentScore;
        private ImageView imageView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            // Instantiate the elements from the comment_list_row onto the adapter.
            foldingCell = itemView.findViewById(R.id.folding_cell);
            tvTitle= itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            imageView = itemView.findViewById(R.id.imageview);
            sentimentScore = itemView.findViewById(R.id.tv_sentimentscore);

        }
    }


    }

