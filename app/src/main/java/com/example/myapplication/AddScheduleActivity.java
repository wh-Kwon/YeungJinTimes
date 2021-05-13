package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity {
    RecyclerView recyclerView = null;
    RecyclerViewAdapter adapter = null;
    ArrayList<TimeAddRecyclerViewItem> list;

    private Spinner daySpinner;
    private Spinner startTimeSpinner;
    private Spinner finishTimeSpinner;


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
//        Spinner spinner = (Spinner) findViewById(R.id.daySpinner);
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {}
//        });

        Button addTime = (Button) findViewById(R.id.addTime);

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.timeRecyclerView);
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        daySpinner = recyclerView.findViewById(R.id.daySpinner);
        startTimeSpinner = recyclerView.findViewById(R.id.startTimeSpinner);
        finishTimeSpinner = recyclerView.findViewById(R.id.finishTimeSpinner);

        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(daySpinner, startTimeSpinner, finishTimeSpinner);
                adapter.notifyDataSetChanged();
            }
        });

//        addItem(daySpinner, startTimeSpinner, finishTimeSpinner);
//        addItem(daySpinner, startTimeSpinner, finishTimeSpinner);
//        addItem(daySpinner, startTimeSpinner, finishTimeSpinner);
    }

    private void addItem(Spinner daySpinner, Spinner startTimeSpinner, Spinner finishTimeSpinner) {
        TimeAddRecyclerViewItem item = new TimeAddRecyclerViewItem();
        item.setDaySpinner(daySpinner);
        item.setStartTimeSpinner(startTimeSpinner);
        item.setFinishTimeSpinner(finishTimeSpinner);
        list.add(item);
    }

}

