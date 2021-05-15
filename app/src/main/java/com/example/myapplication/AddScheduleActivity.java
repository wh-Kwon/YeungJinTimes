package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private RecyclerViewAdapter adapter = null;
    private ArrayList<TimeAddRecyclerViewItem> list;

    private TextView complete;
    private Button addTime;
    private ImageButton deleteTime;

    private Spinner daySpinner;
    private Spinner startTimeSpinner;
    private Spinner finishTimeSpinner;
    private EditText addPlace;


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

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.timeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);

        daySpinner = recyclerView.findViewById(R.id.daySpinner);
        startTimeSpinner = recyclerView.findViewById(R.id.startTimeSpinner);
        finishTimeSpinner = recyclerView.findViewById(R.id.finishTimeSpinner);
        addPlace = recyclerView.findViewById(R.id.addPlace);
        deleteTime = recyclerView.findViewById(R.id.deleteTime);

        addTime = (Button) findViewById(R.id.addTime);
        addTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adapter.getItemCount() < 3) {
                    addItem(daySpinner, startTimeSpinner, finishTimeSpinner, addPlace, deleteTime);
                    adapter.notifyDataSetChanged();
                    if(adapter.getItemCount() == 1) {
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

            }
        });
    }

    private void addItem(Spinner daySpinner, Spinner startTimeSpinner, Spinner finishTimeSpinner, EditText addPlace, ImageButton deleteTime) {
        TimeAddRecyclerViewItem item = new TimeAddRecyclerViewItem();
        item.setDaySpinner(daySpinner);
        item.setStartTimeSpinner(startTimeSpinner);
        item.setFinishTimeSpinner(finishTimeSpinner);
        item.setAddPlace(addPlace);
        item.setDeleteTime(deleteTime);
        list.add(item);
    }


}

