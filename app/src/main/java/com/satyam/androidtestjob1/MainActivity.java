package com.satyam.androidtestjob1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    int[] data = {25, 30, 45};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = findViewById(R.id.pie_chart);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setRotationEnabled(true);
        Add();
    }
    private void Add() {
        ArrayList<PieEntry> Entry=new ArrayList<>();
        for(int i=0;i<data.length;i++){
            Entry.add(new PieEntry(data[i],i));
        }
        PieDataSet pieDataSet=new PieDataSet(Entry,"Details");
        ArrayList<Integer> color=new ArrayList<>();
        color.add(Color.BLUE);
        color.add(Color.GREEN);
        color.add(Color.RED);
        pieDataSet.setColors(color);

        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}