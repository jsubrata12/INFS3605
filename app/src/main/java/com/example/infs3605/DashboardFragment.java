package com.example.infs3605;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {
    private PieChart pieChart;
    ArrayList barArrayList;
    private BarChart barChart;
    private LinearLayout l1,l2,l3,l4;
    private ImageView iv1, iv2, selection;
    private TextView tv1, tv2, tv3, tv4, title, chartTitle;

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
        barChart = v.findViewById(R.id.dashboard_barchart);
        tv1 = v.findViewById(R.id.tvEOI);
        tv2 = v.findViewById(R.id.tvSP);
        tv3 = v.findViewById(R.id.tvIP);
        tv4 = v.findViewById(R.id.tvFunding);
        iv1 = v.findViewById(R.id.shareButton);
        iv2 = v.findViewById(R.id.filterMenu);
        title = v.findViewById(R.id.dbTitle);
        selection = v.findViewById(R.id.dbSelect);
        chartTitle = v.findViewById(R.id.chartTitle);
        l1 = v.findViewById(R.id.eoiLayout);
        l2 = v.findViewById(R.id.submitLayout);
        l3 = v.findViewById(R.id.projectLayout);
        l4 = v.findViewById(R.id.fundingLayout);

        Animation animation= AnimationUtils.loadAnimation(getContext(), R.anim.fadein);

        title.startAnimation(animation);
        selection.startAnimation(animation);
        iv1.startAnimation(animation);
        iv2.startAnimation(animation);
        l1.startAnimation(animation);
        l2.startAnimation(animation);
        l3.startAnimation(animation);
        l4.startAnimation(animation);
        chartTitle.startAnimation(animation);
        barChart.startAnimation(animation);

        selectedFilter = new boolean[filterArray.length];
        //BarDataSet barDataSet = new BarDataSet(barArrayList, "Test");

        BarData barData = null;
        try {
            barData = new BarData(getXAxisValues(), getData());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // BarData barData = new BarData((List<String>) barDataSet);
        barChart.setData(barData);
        //barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //barDataSet.setValueTextColor(Color.BLACK);
       // barDataSet.setValueTextSize(16f);
        // barChart.getDescription().setEnabled(true);
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
                sp.setPadding(60, 0, 0, 0);
                builder.setView(sp);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                            int dummy = (int) sp.getSelectedItemId();
                            if(dummy == 0){
                                tv1.setText("1536");
                                tv2.setText("1049");
                                tv3.setText("2551");
                                tv4.setText("$3,632");
                                BarData barData = null;
                                try {
                                    barData = new BarData(getXAxisValues(), getData2());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                barChart.setData(barData);
                            }
                            if(dummy == 1){
                            tv1.setText("2985");
                            tv2.setText("1428");
                            tv3.setText("2882");
                            tv4.setText("$3,333");
                                BarData barData = null;
                                try {
                                    barData = new BarData(getXAxisValues(), getData3());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                barChart.setData(barData);
                            }
                            if(dummy == 2){
                            tv1.setText("1185");
                            tv2.setText("1692");
                            tv3.setText("1968");
                            tv4.setText("$2,764");
                                BarData barData = null;
                                try {
                                    barData = new BarData(getXAxisValues(), getData4());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                barChart.setData(barData);
                        }
                            if(dummy == 3){
                            tv1.setText("1047");
                            tv2.setText("1283");
                            tv3.setText("1507");
                            tv4.setText("$5,636");
                                BarData barData = null;
                                try {
                                    barData = new BarData(getXAxisValues(), getData());
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                barChart.setData(barData);
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("0");
        xAxis.add("100");
        xAxis.add("200");
        xAxis.add("300");
        xAxis.add("400");
        xAxis.add("500");
        xAxis.add("600");

        return xAxis;
    }

    private ArrayList<BarDataSet> getData() throws ParseException {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> barArrayList = new ArrayList<>();

        barArrayList.add(new BarEntry(100, 0));
        barArrayList.add(new BarEntry(200, 1));
        barArrayList.add(new BarEntry(300, 2));
        barArrayList.add(new BarEntry(400, 3));
        barArrayList.add(new BarEntry(500, 4));

        BarDataSet barDataSet = new BarDataSet(barArrayList, "Test");

        dataSets = new ArrayList<>();
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);
        return dataSets;
    }

    private ArrayList<BarDataSet> getData2() throws ParseException {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> barArrayList = new ArrayList<>();

        barArrayList.add(new BarEntry(150, 0));
        barArrayList.add(new BarEntry(230, 1));
        barArrayList.add(new BarEntry(370, 2));
        barArrayList.add(new BarEntry(420, 3));
        barArrayList.add(new BarEntry(600, 4));

        BarDataSet barDataSet = new BarDataSet(barArrayList, "Test");

        dataSets = new ArrayList<>();
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);
        return dataSets;
    }

    private ArrayList<BarDataSet> getData3() throws ParseException {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> barArrayList = new ArrayList<>();

        barArrayList.add(new BarEntry(130, 0));
        barArrayList.add(new BarEntry(320, 1));
        barArrayList.add(new BarEntry(430, 2));
        barArrayList.add(new BarEntry(620, 3));
        barArrayList.add(new BarEntry(700, 4));

        BarDataSet barDataSet = new BarDataSet(barArrayList, "Test");

        dataSets = new ArrayList<>();
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);
        return dataSets;
    }

    private ArrayList<BarDataSet> getData4() throws ParseException {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> barArrayList = new ArrayList<>();

        barArrayList.add(new BarEntry(200, 0));
        barArrayList.add(new BarEntry(350, 1));
        barArrayList.add(new BarEntry(420, 2));
        barArrayList.add(new BarEntry(510, 3));
        barArrayList.add(new BarEntry(610, 4));

        BarDataSet barDataSet = new BarDataSet(barArrayList, "Test");

        dataSets = new ArrayList<>();
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);
        return dataSets;
    }

}