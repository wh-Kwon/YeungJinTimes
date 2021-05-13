package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<TimeAddRecyclerViewItem> mData = null;

    public RecyclerViewAdapter(ArrayList<TimeAddRecyclerViewItem> data) { mData = data; }

    // onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.time_recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        TimeAddRecyclerViewItem item = mData.get(position);

    }

    // getItemCount : 전체 데이터의 개수를 리턴
    @Override
    public int getItemCount() { return mData.size(); }

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        Spinner daySpinner;
        Spinner startTimeSpinner;
        Spinner finishTimeSpinner;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조
            daySpinner = itemView.findViewById(R.id.daySpinner);
            startTimeSpinner = itemView.findViewById(R.id.startTimeSpinner);
            finishTimeSpinner = itemView.findViewById(R.id.finishTimeSpinner);
        }

    }

}
