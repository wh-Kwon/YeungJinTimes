package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AddScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private RecyclerViewAdapter adapter = null;

    private TextView complete;
    private Button addTime;
    private EditText addClass;
    String className = "";
    ScheduleFragment scheduleFragment = new ScheduleFragment();
    String fileName = "Schedule.txt";

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

//                    scheduleFragment.addSchedule(className, day, startTime, finishTime, placeName);
                    dataInput(className+ "\t" + day + "\t" + startTime + "\t" + finishTime + "\t" + placeName);
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

    public void dataInput(String str) {
        try {
            Log.i("mylog", "cur dir: " + getFilesDir().toString());
            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(str.getBytes());
            fos.close();

//            FileInputStream fis = openFileInput(fileName);
//            String line = new BufferedReader(new InputStreamReader(fis)).readLine();
//            fis.close();
//            Log.i("mylog", "file contents: " + line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataRead(String str) {
        try {
            FileInputStream fis = openFileInput(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
            String resultContents = "";
            String temp = "";
            while(bufferedReader.readLine() != null) {
                temp = bufferedReader.readLine();
                resultContents += temp;
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

