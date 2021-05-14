package com.example.myapplication;

import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class TimeAddRecyclerViewItem {
    private Spinner daySpinner;
    private Spinner startTimeSpinner;
    private Spinner finishTimeSpinner;
    private EditText addPlace;
    private ImageButton deleteTime;

    public void setDaySpinner(Spinner daySpinner) { this.daySpinner = daySpinner; }
    public void setStartTimeSpinner(Spinner startTimeSpinner) { this.startTimeSpinner = startTimeSpinner; }
    public void setFinishTimeSpinner(Spinner finishTimeSpinner) { this.finishTimeSpinner = finishTimeSpinner; }
    public void setAddPlace(EditText addPlace) { this.addPlace = addPlace; }
    public void setDeleteTime(ImageButton deleteTime) { this.deleteTime = deleteTime; }

    public Spinner getDaySpinner() { return daySpinner; }
    public Spinner getStartTimeSpinner() { return startTimeSpinner; }
    public Spinner getFinishTimeSpinner() { return finishTimeSpinner; }
    public EditText getAddPlace() { return addPlace; }
    public ImageButton getDeleteTime() { return deleteTime; }

}
