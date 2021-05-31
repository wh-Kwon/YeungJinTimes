package com.example.myapplication;

import android.widget.TextView;

public class Schedule {
    private String[] monday = new String[9];
    private String[] tuesday = new String[9];
    private String[] wednesday = new String[9];
    private String[] thursday = new String[9];
    private String[] friday = new String[9];

    public Schedule() {
        for(int i=0; i<9; i++){
            monday[i]="";
            tuesday[i]="";
            wednesday[i]="";
            thursday[i]="";
            friday[i]="";
        }
    }

    public void addSchedule(String className, int day, int startTime, int finishTime, String placeName) {
        String text = className + "/n" + placeName;
        for(int i=startTime; i<finishTime; i++) {
            switch(day) {
                case 0:
                    monday[i] = text;
                    break;
                case 1:
                    tuesday[i] = text;
                    break;
                case 2:
                    wednesday[i] = text;
                    break;
                case 3:
                    thursday[i] = text;
                    break;
                case 4:
                    friday[i] = text;
                    break;
            }
        }
    }

    public void setting(TextView[] monday , TextView[] tuesday, TextView[] wednesday, TextView[] thursday, TextView[] friday) {
        for (int i = 0; i < 9; i++) {
            if (!this.monday[i].equals("")) {
                monday[i].setText(this.monday[i]);
            }
            if (!this.tuesday[i].equals("")) {
                tuesday[i].setText(this.tuesday[i]);
            }
            if (!this.wednesday[i].equals("")) {
                wednesday[i].setText(this.wednesday[i]);
            }
            if (!this.thursday[i].equals("")) {
                thursday[i].setText(this.thursday[i]);
            }
            if (!this.friday[i].equals("")) {
                friday[i].setText(this.friday[i]);
            }
        }
    }
}
