package com.example.infs3605;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Example of using Folding Cell with ListView and ListAdapter
 */
public class CommentActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private CommentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        mRecyclerView = findViewById(R.id.rvComment);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setFocusable(false);

        adapter = new CommentAdapter(this);
        mRecyclerView.setAdapter(adapter);

        ArrayList<Comment> list = new ArrayList<>();
        list.add(new Comment("Jim Sample", "Very good, but needs quite a bit of work", R.drawable.curator1,"7.5/10"));
        list.add(new Comment("Jane Test", "I think this might need to be reconsidered", R.drawable.curator2,"7.3/10"));
        list.add(new Comment("Jepp Dhonny", "I think that this is good, but it can still be better", R.drawable.curator3,"7.1/10"));
        list.add(new Comment("Bustin Jiever", " Very good keep up the good work", R.drawable.curator4,"8.5/10"));
        list.add(new Comment("Bruno Earth", "Excellent, I think you did very well", R.drawable.curator5,"9/10"));

        adapter.setData(list);
    }


}
