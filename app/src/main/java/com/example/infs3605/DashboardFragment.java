package com.example.infs3605;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.Constraints;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    private PieChart pieChart;
    ArrayList barArrayList;
    private BarChart barChart;
    private ImageView iv1,iv2;
    private TextView tv1, tv2, tv3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    boolean[] selectedFilter;
    ArrayList<Integer> filterList = new ArrayList<>();
    String[] filterArray = {"Quarter 1", "Quarter 2", "Quarter 3", "Quarter 4"};

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
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
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final ArrayAdapter<String> adp = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, filterArray);
        final Spinner sp = new Spinner(getActivity());

        sp.setAdapter(adp);
        pieChart = v.findViewById(R.id.dashboard_piechart);
        barChart = v.findViewById(R.id.dashboard_barchart);
        tv1 = v.findViewById(R.id.tvEOI);
        tv2 = v.findViewById(R.id.tvSP);
        tv3 = v.findViewById(R.id.tvIP);
        iv1 = v.findViewById(R.id.shareButton);
        iv2 = v.findViewById(R.id.filterMenu);
        selectedFilter = new boolean[filterArray.length];
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList,"Test");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
        try {
            CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.qualitative)));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                tv1.setText(nextLine[1]);
                tv2.setText(nextLine[2]);
                tv3.setText(nextLine[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setupPieChart();
        loadPieChartData();

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String body = "Download this App";
                String sub = "http://play.google.com";
                intent.putExtra(Intent.EXTRA_TEXT, body);
                intent.putExtra(Intent.EXTRA_TEXT, sub);
                startActivity(Intent.createChooser(intent, "ShareVia"));

            }

        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Filter List");
                builder.setMessage("Specify quarter");
                builder.setCancelable(false);
                sp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                sp.setPadding(60,0,0,0);
                builder.setView(sp);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.qualitative)));
                            String[] nL;
                            int dummy = (int) sp.getSelectedItemId();
                            String dummyConv = String.valueOf(dummy+1);
                            while ((nL = reader.readNext()) !=  null ) {
                                if(nL[0] == dummyConv){
                                    tv1.setText(nL[1]);
                                    tv2.setText(nL[2]);
                                    tv3.setText(nL[3]);
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    }
                });
                builder.create().show();            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    private void getData(){
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f,10));
        barArrayList.add(new BarEntry(3f,10));
        barArrayList.add(new BarEntry(4f,10));
        barArrayList.add(new BarEntry(5f,10));
        barArrayList.add(new BarEntry(6f,10));
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(android.R.color.black);
        pieChart.setCenterText("Test");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);

    }

    private void loadPieChartData(){
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.2f,"Test"));
        entries.add(new PieEntry(0.15f,"Test 2"));
        entries.add(new PieEntry(0.10f,"Test 3"));
        entries.add(new PieEntry(0.25f,"Test 4"));
        entries.add(new PieEntry(0.3f,"Test 5"));

        ArrayList<Integer> colors = new ArrayList<>();
        for(int color: ColorTemplate.MATERIAL_COLORS) {
            colors.add(color);
        }

        for(int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Test Cat");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

    }
}