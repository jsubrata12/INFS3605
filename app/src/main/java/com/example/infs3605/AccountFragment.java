package com.example.infs3605;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private LinearLayout l1,l2,l3,l4;
    private ImageView iv1;
    private TextView tv1,tv2;

    public AccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        l1 = v.findViewById(R.id.layout1);
        l2 = v.findViewById(R.id.layout2);
        l3 = v.findViewById(R.id.layout3);
        l4 = v.findViewById(R.id.layout4);
        iv1= v.findViewById(R.id.profilePic);
        tv1 = v.findViewById(R.id.tvFullName);
        tv2 = v.findViewById(R.id.tvPos);
        Animation animation= AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        iv1.startAnimation(animation);
        tv1.startAnimation(animation);
        tv2.startAnimation(animation);
        l1.startAnimation(animation);
        l2.startAnimation(animation);
        l3.startAnimation(animation);
        l4.startAnimation(animation);

        // Inflate the layout for this fragment
        return v;
    }
}