package com.example.infs3605;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.material.chip.Chip;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

public class SDGActivity extends AppCompatActivity {
    TextView test;
    RecyclerView sdgRv;
    SDGAdapter sdgAdapter;
    Project project = new Project();
    SDG sd = new SDG();
    HorizontalBarChart mChart;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdgs);

        test = findViewById(R.id.sdgCount);
        sdgRv = findViewById(R.id.sdgRV);
        mChart = findViewById(R.id.sdgChart);

        sdgRv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        sdgRv.setLayoutManager(layoutManager);

        SDGAdapter.OnItemClickListener clickListener = new SDGAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, String id) {
            }
        };

        List<SDG> sdgList = SDG.getSDG();

        sdgAdapter = new SDGAdapter((ArrayList<SDG>) sdgList, clickListener);
        sdgRv.setAdapter(sdgAdapter);

        ArrayList<Project> projectArrayList = project.getProject();

        mChart.setTouchEnabled(true);
        mChart.setClickable(false);
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setDoubleTapToZoomEnabled(false);

        mChart.setDrawBorders(false);
        mChart.setDrawGridBackground(false);

        // mChart.getDescription().setEnabled(false);
        mChart.setDescription("");
        mChart.getLegend().setEnabled(false);

        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisLeft().setDrawLabels(false);
        mChart.getAxisLeft().setDrawAxisLine(false);

        mChart.getXAxis().setDrawGridLines(false);
        //mChart.getXAxis().setDrawLabels(false);
        mChart.getXAxis().setDrawAxisLine(false);

        mChart.getAxisRight().setDrawGridLines(false);
        mChart.getAxisRight().setDrawLabels(false);
        mChart.getAxisRight().setDrawAxisLine(false);

        BarData barData = null;
        try {
            barData = new BarData(getYAxisValues(), getDataSet());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        XAxis xaxis = mChart.getXAxis();
        xaxis.setDrawGridLines(false);
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setDrawLabels(true);
        xaxis.setXOffset(5);
        xaxis.setDrawAxisLine(false);


        mChart.setData(barData);
        mChart.invalidate();

    }

    private ArrayList<String> getYAxisValues() {
        ArrayList<String> yAxis = new ArrayList<>();
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        yAxis.add("");
        /*yAxis.add("Partnerships for the Goals");
        yAxis.add("Peace, Justice and Strong Institutions");
        yAxis.add("Life on Land");
        yAxis.add("Life Below Water");
        yAxis.add("Climate Action");
        yAxis.add("Responsible Consumption and Production");
        yAxis.add("Sustainable Cities and Communities");
        yAxis.add("Reduced Inequalities");
        yAxis.add("Industry, Innovation and Infrastructure");
        yAxis.add("Decent Work and Economic Growth");
        yAxis.add("Affordable and Clean Energy");
        yAxis.add("Clean Water and Sanitation");
        yAxis.add("Gender Equality");
        yAxis.add("Quality Education");
        yAxis.add("Good Health and Well-being");
        yAxis.add("Zero Hunger");
        yAxis.add("No Poverty");*/
        yAxis.add("17");
        yAxis.add("");
        yAxis.add("16");
        yAxis.add("");
        yAxis.add("15");
        yAxis.add("");
        yAxis.add("14");
        yAxis.add("");
        yAxis.add("13");
        yAxis.add("");
        yAxis.add("12");
        yAxis.add("");
        yAxis.add("11");
        yAxis.add("");
        yAxis.add("10");
        yAxis.add("");
        yAxis.add("9");
        yAxis.add("");
        yAxis.add("8");
        yAxis.add("");
        yAxis.add("7");
        yAxis.add("");
        yAxis.add("6");
        yAxis.add("");
        yAxis.add("5");
        yAxis.add("");
        yAxis.add("4");
        yAxis.add("");
        yAxis.add("3");
        yAxis.add("");
        yAxis.add("2");
        yAxis.add("");
        yAxis.add("1");


        return yAxis;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<BarDataSet> getDataSet() throws ParseException {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet = new ArrayList<>();
        ArrayList<SDG> sdgList = sd.getSDG();

        Project project = new Project();
        ArrayList<Project> projects = project.getProject();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;
        int count10 = 0;
        int count11 = 0;
        int count12 = 0;
        int count13 = 0;
        int count14 = 0;
        int count15 = 0;
        int count16 = 0;
        int count17 = 0;

        for (SDG sdg : sdgList) {
            for (Project s : projects) {
                if (sdg.getSdgName().equals("No Poverty") && s.isSdg1() == true) {
                    count1++;
                    BarEntry value1 = new BarEntry(count1, 47);
                    valueSet.add(value1);
                    System.out.println("SDG1 Count is: " + count1);
                } else if (sdg.getSdgName().equals("Zero Hunger") && s.isSdg2() == true) {
                    count2++;
                    BarEntry value2 = new BarEntry(count2, 45);
                    valueSet.add(value2);
                    System.out.println("SDG2 Count is: " + count2);
                }
                if (sdg.getSdgName().equals("Good Health and Well-being") && s.isSdg3() == true) {
                    count3++;
                    BarEntry value3 = new BarEntry(count3, 43);
                    valueSet.add(value3);
                }
                if (sdg.getSdgName().equals("Quality Education") && s.isSdg4() == true) {
                    count4++;
                    BarEntry value4 = new BarEntry(count4, 41);
                    valueSet.add(value4);
                }
                if (sdg.getSdgName().equals("Gender Equality") && s.isSdg5() == true) {
                    count5++;
                    BarEntry value5 = new BarEntry(count5, 39);
                    valueSet.add(value5);
                }
                if (sdg.getSdgName().equals(" Clean Water and Sanitation") && s.isSdg6() == true) {
                    count6++;
                    BarEntry value6 = new BarEntry(count6, 37);
                    valueSet.add(value6);
                }
                if (sdg.getSdgName().equals("Affordable and Clean Energy") && s.isSdg7() == true) {
                    count7++;
                    BarEntry value7 = new BarEntry(count7, 35);
                    valueSet.add(value7);
                }
                if (sdg.getSdgName().equals("Decent Work and Economic Growth") && s.isSdg8() == true) {
                    count8++;
                    BarEntry value8 = new BarEntry(count8, 33);
                    valueSet.add(value8);
                }
                if (sdg.getSdgName().equals("Industry, Innovation and Infrastructure") && s.isSdg9() == true) {
                    count9++;
                    BarEntry value9 = new BarEntry(count9, 31);
                    valueSet.add(value9);
                }
                if (sdg.getSdgName().equals("Reduced Inequalities") && s.isSdg10() == true) {
                    count10++;
                    BarEntry value10 = new BarEntry(count10, 29);
                    valueSet.add(value10);
                }
                if (sdg.getSdgName().equals("Sustainable Cities and Communities") && s.isSdg11() == true) {
                    count11++;
                    BarEntry value1 = new BarEntry(count11, 27);
                    valueSet.add(value1);
                }
                if (sdg.getSdgName().equals("Responsible Consumption and Production") && s.isSdg12() == true) {
                    count12++;
                    BarEntry value12 = new BarEntry(count12, 25);
                    valueSet.add(value12);
                }
                if (sdg.getSdgName().equals("Climate Action") && s.isSdg13() == true) {
                    count13++;
                    BarEntry value13 = new BarEntry(count13, 23);
                    valueSet.add(value13);
                }
                if (sdg.getSdgName().equals("Life Below Water") && s.isSdg14() == true) {
                    count14++;
                    BarEntry value14 = new BarEntry(count14, 21);
                    valueSet.add(value14);
                }
                if (sdg.getSdgName().equals("Life on Land") && s.isSdg15() == true) {
                    count15++;
                    BarEntry value15 = new BarEntry(count15, 19);
                    valueSet.add(value15);
                }
                if (sdg.getSdgName().equals("Peace, Justice and Strong Institutions") && s.isSdg16() == true) {
                    count16++;
                    BarEntry value16 = new BarEntry(count16, 17);
                    valueSet.add(value16);
                }
                if (sdg.getSdgName().equals("Partnerships for the Goals") && s.isSdg17() == true) {
                    count17++;
                    BarEntry value17 = new BarEntry(count17, 15);

                    valueSet.add(value17);
                }
            }
        }

        BarDataSet barDataSet = new BarDataSet(valueSet, "Test");

        ArrayList<Integer> colors = new ArrayList<Integer>();

        colors.add(getResources().getColor(R.color.sdg1)); // Tes
        colors.add(getResources().getColor(R.color.sdg1)); // Test
        colors.add(getResources().getColor(R.color.sdg2)); // Test
        colors.add(getResources().getColor(R.color.sdg2)); // Test
        colors.add(getResources().getColor(R.color.sdg3)); // Test
        colors.add(getResources().getColor(R.color.sdg3)); // Test
        colors.add(getResources().getColor(R.color.sdg4)); // Leave
        colors.add(getResources().getColor(R.color.sdg4)); // Leave
        colors.add(getResources().getColor(R.color.sdg5)); // Leave
        colors.add(getResources().getColor(R.color.sdg5)); // Leave
        colors.add(getResources().getColor(R.color.sdg7)); // Leave
        colors.add(getResources().getColor(R.color.sdg7)); // Leave
        colors.add(getResources().getColor(R.color.sdg8));
        colors.add(getResources().getColor(R.color.sdg8));
        colors.add(getResources().getColor(R.color.sdg9)); // Leave
        colors.add(getResources().getColor(R.color.sdg9)); // Leave
        colors.add(getResources().getColor(R.color.sdg10)); // Leave
        colors.add(getResources().getColor(R.color.sdg10)); // Leave
        colors.add(getResources().getColor(R.color.sdg11)); // Leave
        colors.add(getResources().getColor(R.color.sdg11)); // Leave
        colors.add(getResources().getColor(R.color.sdg11)); // Leave
        colors.add(getResources().getColor(R.color.sdg11)); // Leave
        colors.add(getResources().getColor(R.color.sdg12)); // Leave
        colors.add(getResources().getColor(R.color.sdg12)); // Leave
        colors.add(getResources().getColor(R.color.sdg13)); // Lea
        colors.add(getResources().getColor(R.color.sdg13)); // Lea
        colors.add(getResources().getColor(R.color.sdg13)); // Lea
        colors.add(getResources().getColor(R.color.sdg13)); // Lea
        colors.add(getResources().getColor(R.color.sdg14)); // Leave
        colors.add(getResources().getColor(R.color.sdg14)); // Leave
        colors.add(getResources().getColor(R.color.sdg14)); // Leave
        colors.add(getResources().getColor(R.color.sdg14)); // Leave
        colors.add(getResources().getColor(R.color.sdg15)); // Leave
        colors.add(getResources().getColor(R.color.sdg15)); // Leave
        colors.add(getResources().getColor(R.color.sdg15)); // Leave
        colors.add(getResources().getColor(R.color.sdg16)); // Leave*/
        colors.add(getResources().getColor(R.color.sdg16)); // Leave*/
        colors.add(getResources().getColor(R.color.sdg16)); // Leave*/
        colors.add(getResources().getColor(R.color.sdg17)); // Leave*/
        colors.add(getResources().getColor(R.color.sdg17)); // Leave*/
        colors.add(getResources().getColor(R.color.sdg6));
        colors.add(getResources().getColor(R.color.sdg6));


        barDataSet.setColors(colors);

        dataSets = new ArrayList<>();
        barDataSet.setDrawValues(false);
        dataSets.add(barDataSet);
        return dataSets;
    }
}