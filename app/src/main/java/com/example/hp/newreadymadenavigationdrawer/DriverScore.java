package com.example.hp.newreadymadenavigationdrawer;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DriverScore extends Fragment {


    public DriverScore() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        View rootView = inflater.inflate(R.layout.fragment_driver_score,null);

        PieChart pieChart = (PieChart)rootView.findViewById(R.id.pieChart);

        piechart_operations(pieChart);
        return rootView;

    }

    private void piechart_operations(PieChart pieChart) {


        pieChart.getDescription().setEnabled(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.setRotationEnabled(true);
        pieChart.setBackgroundColor(Color.CYAN);
        //pieChart.setUsePercentValues(true);
        //pieChart.setHoleColor(Color.BLUE);
        //pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(90f);
        pieChart.setHoleColor(Color.CYAN);

        pieChart.setCenterText("Today's Driver Score\n80");
        pieChart.setCenterTextSize(35f);


        addDataSet(pieChart);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!
    }


    private void addDataSet(PieChart pieChart) {
        String TAG = "Fragment Activity";
        float[] yData = {25.3f, 10.6f, 66.76f, 44.32f, 46.01f, 16.89f, 23.9f};

        float[] Score_Data = {80f,20f};
        String[] xData = {"Mitch", "Jessica", "Mohammad", "Kelsey", "Sam", "Robert", "Ashley"};
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for (int i = 0; i < Score_Data.length; i++) {
            yEntrys.add(new PieEntry(Score_Data[i], i));
        }

        for (int i = 1; i < xData.length; i++) {
            xEntrys.add(xData[i]);
        }

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Employee Sales");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(0);

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.WHITE);
        colors.add(Color.GRAY);
        // colors.add(Color.BLUE);
        // colors.add(Color.RED);
        // colors.add(Color.GREEN);
        //colors.add(Color.CYAN);
        //colors.add(Color.YELLOW);
        //colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to chart
        //Legend legend = pieChart.getLegend();
        //legend.setForm(Legend.LegendForm.CIRCLE);


        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

}
