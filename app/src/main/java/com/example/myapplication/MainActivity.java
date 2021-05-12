package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule);

        ImageView addScheduleButton = (ImageView) findViewById(R.id.addScheduleButton);
        addScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addScheduleIntent = new Intent(MainActivity.this, AddScheduleActivity.class);
                MainActivity.this.startActivity(addScheduleIntent);
            }
        });

        ImageView scheduleListButton = (ImageView) findViewById(R.id.scheduleListButton);
        scheduleListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scheduleListIntent = new Intent(MainActivity.this, ScheduleListActivity.class);
                MainActivity.this.startActivity(scheduleListIntent);
            }
        });
    }
}