package com.example.hp.newreadymadenavigationdrawer;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class PastBehavior extends AppCompatActivity {
    BarChart mbarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_behavior);

        mbarChart = (BarChart)findViewById(R.id.barChart);

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(0,62));
        entries.add(new BarEntry(1,73));
        entries.add(new BarEntry(2,78));
        entries.add(new BarEntry(3,83));
        entries.add(new BarEntry(4,85));
        entries.add(new BarEntry(5,80));
        entries.add(new BarEntry(6,64));
        entries.add(new BarEntry(7,43));
        entries.add(new BarEntry(8,89));
        entries.add(new BarEntry(9,45));
        entries.add(new BarEntry(10,67));
        entries.add(new BarEntry(11,88));




        BarDataSet dataSet = new BarDataSet(entries, "This is a bar chart");
        dataSet.setColor(Color.rgb(255,255,255));



        BarData barData = new BarData(dataSet);


        XAxis xAxis = mbarChart.getXAxis();
        xAxis.setTextSize(11f);
        xAxis.setXOffset(0);
        xAxis.setYOffset(0);

        xAxis.setValueFormatter(new IAxisValueFormatter() {

            private String[] qualities = new String[]{"Days"};
            @Override

            public String getFormattedValue(float value, AxisBase axis) {
                return qualities[(int)value % qualities.length];
            }
        });

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularityEnabled(true);
        xAxis.setAxisLineColor(Color.WHITE);
        xAxis.setTextColor(Color.WHITE);

        mbarChart.setBackgroundColor(Color.rgb(0,206,209));
        mbarChart.getDescription().setEnabled(false);
        mbarChart.getLegend().setEnabled(false);
        mbarChart.getAxisRight().setEnabled(false);
        mbarChart.setDrawGridBackground(false);
        mbarChart.getAxisLeft().setTextSize(13f);
        mbarChart.getAxisLeft().setTextColor(Color.WHITE);
        mbarChart.getAxisLeft().setAxisLineColor(Color.WHITE);
        mbarChart.setData(barData);
        mbarChart.getAxisRight().setDrawGridLines(false);
        mbarChart.getAxisLeft().setDrawGridLines(false);
        mbarChart.getXAxis().setDrawGridLines(false);

        mbarChart.invalidate();

    }
}
