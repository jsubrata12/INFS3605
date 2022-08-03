package com.example.infs3605;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private FavoriteAdapter mFavoriteAdapter;
    public static final String EXTRA_MESSAGE = "favorite fragment";
    private ArrayList<Task> tasks;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FavoriteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavoriteFragment newInstance(String param1, String param2) {
        FavoriteFragment fragment = new FavoriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_favorite, container, false);

        mRecyclerView = v.findViewById(R.id.toActionRv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(v.getContext());
        mRecyclerView.setLayoutManager(layoutManager);

        FavoriteAdapter.RecyclerViewClickListener listener = new FavoriteAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int taskId) {
                launchDetailActivity(taskId);
            }
        };

        Button mAddBtn = v.findViewById(R.id.addButton);
        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAddActivity();
            }
        });

        DatabaseReference referenceTask = FirebaseDatabase.getInstance().getReference("Task");
        tasks = new ArrayList<>();
        mFavoriteAdapter = new FavoriteAdapter(tasks, listener);
        referenceTask.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                tasks.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){

                    Task task = dataSnapshot.getValue(Task.class);
                    if (!task.isCompleted()) {
                        tasks.add(task);
                    }

                }

                mFavoriteAdapter.notifyDataSetChanged();
                System.out.println(tasks);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        mRecyclerView.setAdapter(mFavoriteAdapter);
        return v;
    }

    public void launchDetailActivity(int taskId) {
        Intent intent = new Intent(getActivity(), TaskDetailActivity.class);
        intent.putExtra(EXTRA_MESSAGE, taskId+"");
        startActivity(intent);
    }

    public void launchAddActivity() {
        Intent intent = new Intent(getActivity(), AddTaskActivity.class);
        startActivity(intent);
    }
}