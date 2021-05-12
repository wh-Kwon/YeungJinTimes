package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ScheduleListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_list);

        ImageView backScreenButton = (ImageView) findViewById(R.id.backScreenButton);
        backScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivityIntent = new Intent(ScheduleListActivity.this, MainActivity.class);
                ScheduleListActivity.this.startActivity(MainActivityIntent);
            }
        });
    }


}