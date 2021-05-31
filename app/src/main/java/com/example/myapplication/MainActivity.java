package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();;;
    private ScheduleFragment scheduleFragment = new ScheduleFragment();;
    private FragmentTransaction transaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule);

        transaction.replace(R.id.frameLayout, scheduleFragment).commitAllowingStateLoss();

        ImageView addScheduleButton = (ImageView) findViewById(R.id.addScheduleButton);
        addScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addScheduleIntent = new Intent(MainActivity.this, AddScheduleActivity.class);
                MainActivity.this.startActivity(addScheduleIntent);
            }
        });

    }

    public void reload() {
        transaction.detach(scheduleFragment).attach(scheduleFragment).commit();
    }

}