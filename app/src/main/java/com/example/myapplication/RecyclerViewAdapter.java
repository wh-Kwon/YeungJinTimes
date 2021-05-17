package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ArrayList<TimeAddRecyclerViewItem> mData = null;

    public RecyclerViewAdapter(ArrayList<TimeAddRecyclerViewItem> data) { mData = data; }

    public ArrayList<TimeAddRecyclerViewItem> getmData() { return mData; }

    // onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.deleteTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    // getItemCount : 전체 데이터의 개수를 리턴
    @Override
    public int getItemCount() { return mData.size(); }

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected EditText addClass;
        protected Spinner daySpinner;
        protected Spinner startTimeSpinner;
        protected Spinner finishTimeSpinner;
        protected EditText addPlace;
        protected ImageButton deleteTime;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조
            addClass = itemView.findViewById(R.id.addClass);
            daySpinner = itemView.findViewById(R.id.daySpinner);
            startTimeSpinner = itemView.findViewById(R.id.startTimeSpinner);
            finishTimeSpinner = itemView.findViewById(R.id.finishTimeSpinner);
            addPlace = itemView.findViewById(R.id.addPlace);
            deleteTime = itemView.findViewById(R.id.deleteTime);
        }

    }

}
