package com.example.hp.newreadymadenavigationdrawer;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DemoFragment extends Fragment {


    public DemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_demo,null);
        RadarChart mChart = (RadarChart)rootView.findViewById(R.id.radarChart);
        radar_chart_operations(mChart);
        return rootView;

    }

    private void radar_chart_operations(RadarChart mChart) {


        ArrayList<RadarEntry> entries1 = new ArrayList<>();
        ArrayList<RadarEntry> entries2 = new ArrayList<>();

        entries1.add(new RadarEntry(4f, 0));
        entries1.add(new RadarEntry(5f, 1));
        entries1.add(new RadarEntry(2f, 2));
        entries1.add(new RadarEntry(7f, 3));
        entries1.add(new RadarEntry(6f, 4));
        //entries1.add(new RadarEntry(5f, 5));

        entries2.add(new RadarEntry(1f, 0));
        entries2.add(new RadarEntry(5f, 1));
        entries2.add(new RadarEntry(6f, 2));
        entries2.add(new RadarEntry(3f, 3));
        entries2.add(new RadarEntry(4f, 4));
        //entries2.add(new RadarEntry(8f, 5));

        RadarDataSet radarDataSet_comp1 = new RadarDataSet(entries1,"Today");

        RadarDataSet radarDataSet_comp2 = new RadarDataSet(entries2,"Your Best");

        radarDataSet_comp1.setColor(Color.BLACK);
        radarDataSet_comp2.setColor(Color.RED);
        radarDataSet_comp1.setLineWidth(6f);
        radarDataSet_comp2.setLineWidth(6f);
        radarDataSet_comp1.setDrawFilled(true);
        radarDataSet_comp2.setDrawFilled(true);
        //radarDataSet_comp2.setFillColor(Color.rgb(255,0,0));
        //radarDataSet_comp1.setFillColor(Color.rgb(0,10,245));

        ArrayList<IRadarDataSet> radarDataSets = new ArrayList<>();

        radarDataSets.add(radarDataSet_comp1);
        radarDataSets.add(radarDataSet_comp2);



        RadarData radarData = new RadarData(radarDataSets);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTextSize(12f);
        xAxis.setXOffset(0);
        xAxis.setYOffset(0);

        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] qualities = new String[]{"Braking","Acceleration","Clutch Use","Over-speeding","Gear Use"};
            @Override

            public String getFormattedValue(float value, AxisBase axis) {
                return qualities[(int)value % qualities.length];
            }
        });

        xAxis.setTextColor(Color.BLACK);

        Legend l= mChart.getLegend();

        l.setTextSize(30f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(8f);
        l.setYEntrySpace(5f);

        l.setTextColor(Color.BLACK);


        mChart.setBackgroundColor(Color.rgb(64,224,208));
        mChart.getDescription().setEnabled(false);
        mChart.setWebLineWidth(1f);
        mChart.setWebColor(Color.WHITE);
        mChart.setWebLineWidthInner(2f);

        mChart.setWebColorInner(Color.WHITE);


        mChart.setData(radarData);
        mChart.invalidate();
    }

}
