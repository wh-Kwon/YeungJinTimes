package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ScheduleFragment extends Fragment {
    private TextView monday[] = new TextView[10];
    private TextView tuesday[] = new TextView[10];
    private TextView wednesday[] = new TextView[10];
    private TextView thursday[] = new TextView[10];
    private TextView friday[] = new TextView[10];

    private String[] mondayText = new String[9];
    private String[] tuesdayText = new String[9];
    private String[] wednesdayText = new String[9];
    private String[] thursdayText = new String[9];
    private String[] fridayText = new String[9];

    public ScheduleFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.schedule, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle b) {
        super.onActivityCreated(b);
        monday[0] = getActivity().findViewById(R.id.monday0);
        monday[1] = getActivity().findViewById(R.id.monday1);
        monday[2] = getActivity().findViewById(R.id.monday2);
        monday[3] = getActivity().findViewById(R.id.monday3);
        monday[4] = getActivity().findViewById(R.id.monday4);
        monday[5] = getActivity().findViewById(R.id.monday5);
        monday[6] = getActivity().findViewById(R.id.monday6);
        monday[7] = getActivity().findViewById(R.id.monday7);
        monday[8] = getActivity().findViewById(R.id.monday8);
        monday[9] = getActivity().findViewById(R.id.monday9);

        tuesday[0] = getActivity().findViewById(R.id.tuesday0);
        tuesday[1] = getActivity().findViewById(R.id.tuesday1);
        tuesday[2] = getActivity().findViewById(R.id.tuesday2);
        tuesday[3] = getActivity().findViewById(R.id.tuesday3);
        tuesday[4] = getActivity().findViewById(R.id.tuesday4);
        tuesday[5] = getActivity().findViewById(R.id.tuesday5);
        tuesday[6] = getActivity().findViewById(R.id.tuesday6);
        tuesday[7] = getActivity().findViewById(R.id.tuesday7);
        tuesday[8] = getActivity().findViewById(R.id.tuesday8);
        tuesday[9] = getActivity().findViewById(R.id.tuesday9);

        wednesday[0] = getActivity().findViewById(R.id.wednesday0);
        wednesday[1] = getActivity().findViewById(R.id.wednesday1);
        wednesday[2] = getActivity().findViewById(R.id.wednesday2);
        wednesday[3] = getActivity().findViewById(R.id.wednesday3);
        wednesday[4] = getActivity().findViewById(R.id.wednesday4);
        wednesday[5] = getActivity().findViewById(R.id.wednesday5);
        wednesday[6] = getActivity().findViewById(R.id.wednesday6);
        wednesday[7] = getActivity().findViewById(R.id.wednesday7);
        wednesday[8] = getActivity().findViewById(R.id.wednesday8);
        wednesday[9] = getActivity().findViewById(R.id.wednesday9);

        thursday[0] = getActivity().findViewById(R.id.thursday0);
        thursday[1] = getActivity().findViewById(R.id.thursday1);
        thursday[2] = getActivity().findViewById(R.id.thursday2);
        thursday[3] = getActivity().findViewById(R.id.thursday3);
        thursday[4] = getActivity().findViewById(R.id.thursday4);
        thursday[5] = getActivity().findViewById(R.id.thursday5);
        thursday[6] = getActivity().findViewById(R.id.thursday6);
        thursday[7] = getActivity().findViewById(R.id.thursday7);
        thursday[8] = getActivity().findViewById(R.id.thursday8);
        thursday[9] = getActivity().findViewById(R.id.thursday9);

        friday[0] = getActivity().findViewById(R.id.friday0);
        friday[1] = getActivity().findViewById(R.id.friday1);
        friday[2] = getActivity().findViewById(R.id.friday2);
        friday[3] = getActivity().findViewById(R.id.friday3);
        friday[4] = getActivity().findViewById(R.id.friday4);
        friday[5] = getActivity().findViewById(R.id.friday5);
        friday[6] = getActivity().findViewById(R.id.friday6);
        friday[7] = getActivity().findViewById(R.id.friday7);
        friday[8] = getActivity().findViewById(R.id.friday8);
        friday[9] = getActivity().findViewById(R.id.friday9);

    }

    public void setting() {
        for (int i = 0; i < 9; i++) {
            if (!mondayText[i].equals("")) {
                monday[i].setText(mondayText[i]);
            }
            if (!tuesdayText[i].equals("")) {
                tuesday[i].setText(tuesdayText[i]);
            }
            if (!wednesdayText[i].equals("")) {
                wednesday[i].setText(wednesdayText[i]);
            }
            if (!thursdayText[i].equals("")) {
                thursday[i].setText(thursdayText[i]);
            }
            if (!fridayText[i].equals("")) {
                friday[i].setText(fridayText[i]);
            }
        }
    }

    public void addSchedule(String className, int day, int startTime, int finishTime, String placeName) {
        String text = className + "/n" + placeName;
        for(int i=startTime; i<finishTime; i++) {
            switch(day) {
                case 0:
                    mondayText[i] = text;
                    break;
                case 1:
                    tuesdayText[i] = text;
                    break;
                case 2:
                    wednesdayText[i] = text;
                    break;
                case 3:
                    thursdayText[i] = text;
                    break;
                case 4:
                    fridayText[i] = text;
                    break;
            }
        }
    }


}
