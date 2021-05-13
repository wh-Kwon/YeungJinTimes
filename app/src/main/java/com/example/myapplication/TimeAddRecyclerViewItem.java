package com.example.myapplication;

import android.widget.Spinner;

public class TimeAddRecyclerViewItem {
    Spinner daySpinner;
    Spinner startTimeSpinner;
    Spinner finishTimeSpinner;
    public void setDaySpinner(Spinner daySpinner) { this.daySpinner = daySpinner; }
    public void setStartTimeSpinner(Spinner startTimeSpinner) { this.startTimeSpinner = startTimeSpinner; }
    public void setFinishTimeSpinner(Spinner finishTimeSpinner) { this.finishTimeSpinner = finishTimeSpinner; }
    public Spinner getDaySpinner() { return daySpinner; }
    public Spinner getStartTimeSpinner() { return startTimeSpinner; }
    public Spinner getFinishTimeSpinner() { return finishTimeSpinner; }

}
