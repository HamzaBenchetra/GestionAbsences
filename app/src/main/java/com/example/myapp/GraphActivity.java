package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class GraphActivity<GraphView> extends AppCompatActivity {

    private DataPoint[] getDataPoint(){
        DataPoint []dp = new DataPoint[]{
                new DataPoint(1,6),
                new DataPoint(2,1),
                new DataPoint(3,8),
                new DataPoint(4,0),
                new DataPoint(5,2),
                new DataPoint(6,5),
        };
        return dp;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GraphView graph=(GraphView) findViewById(R.id.graph);
        BarGraphSeries<DataPoint> series = new BarGraphSeries<>(getDataPoint());
        graph.addSeries(series);

        //Les numéros en haut représentent les séances.
        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLACK);

        series.setValueDependentColor(new ValueDependentColor<DataPoint>){

        public int getDP(DataPoint d){
                if(d.getY()>10)
                    return Color.RED;
                else
                    if(dataPoint.getY()>5)
                        return Color.YELLOW;
                    else
                        return Color.GREEN;

            }
        }

    }


}