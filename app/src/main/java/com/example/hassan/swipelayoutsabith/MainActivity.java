package com.example.hassan.swipelayoutsabith;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int number;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mySwipe);
        tv = (TextView) findViewById(R.id.myTextView);
        tv.setText("Total Swipe = 0");

        swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.BLUE);

        swipeRefreshLayout.setColorSchemeColors(Color.GREEN, Color.YELLOW, Color.RED);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               number ++;
               tv.setText("Total Swipe =" +number);

               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       swipeRefreshLayout.setRefreshing(false);
                   }
               },3000);
            }
        });
    }
}
