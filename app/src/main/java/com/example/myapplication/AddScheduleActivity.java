package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private RecyclerViewAdapter adapter = null;

    private TextView complete;
    private Button addTime;
    private EditText addClass;
    String className = "";
    Schedule schedule = new Schedule();
    ScheduleFragment scheduleFragment = new ScheduleFragment();
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_schedule);

        ImageView backScreenButton = (ImageView) findViewById(R.id.exitThisScreenButton);
        backScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivityIntent = new Intent(AddScheduleActivity.this, MainActivity.class);
                AddScheduleActivity.this.startActivity(MainActivityIntent);
            }
        });

        recyclerView = findViewById(R.id.timeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addClass = (EditText) findViewById(R.id.addClass);
        addClass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                className = addClass.getText().toString();
            }
        });

        addTime = (Button) findViewById(R.id.addTime);
        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adapter.getItemCount() < 3) {
                    addItem();
                    if (adapter.getItemCount() == 1) {
                        complete.setBackgroundColor(Color.RED);
                        complete.setTextColor(Color.WHITE);
                    }
                }
            }
        });

        complete = (TextView) findViewById(R.id.completeButton);
        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0; i< adapter.getItemCount(); i++) {
                    ItemModel model = adapter.getmData().get(i);
                    int day = model.getDay();
                    int startTime = model.getStartTime();
                    int finishTime = model.getFinishTime();
                    String placeName = model.getPlaceName();

                    schedule.addSchedule(className, day, startTime, finishTime, placeName);
                }
//                main.reload();
                Intent MainActivityIntent = new Intent(AddScheduleActivity.this, MainActivity.class);
                AddScheduleActivity.this.startActivity(MainActivityIntent);
            }
        });

        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void addItem() {
        ItemModel model = new ItemModel();
        model.setDay(0);
        model.setStartTime(0);
        model.setFinishTime(1);
        model.setPlaceName("");
        adapter.addItem(model);
    }


}

