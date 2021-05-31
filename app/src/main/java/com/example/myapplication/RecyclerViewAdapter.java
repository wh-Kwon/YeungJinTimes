package com.example.myapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {



    private ArrayList<ItemModel> mData = new ArrayList<>();
    public RecyclerViewAdapter() {}

    public ArrayList<ItemModel> getmData() {
        return mData;
    }

    // onCreateViewHolder : 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_recycler_item, parent, false);
        RecyclerViewAdapter.ViewHolder vh = new RecyclerViewAdapter.ViewHolder(view);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // onBindViewHolder : position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override public void onBindViewHolder(ViewHolder holder, int pos) {
        holder.daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mData.get(pos).setDay(holder.daySpinner.getSelectedItemPosition());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        holder.startTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mData.get(pos).setDay(holder.startTimeSpinner.getSelectedItemPosition());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        holder.finishTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mData.get(pos).setDay(holder.finishTimeSpinner.getSelectedItemPosition());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        holder.addPlace.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                mData.get(pos).setPlaceName(holder.addPlace.getText().toString());
            }
        });

        holder.deleteTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(pos);
                notifyDataSetChanged();
            }
        });
    }

    // getItemCount : 전체 데이터의 개수를 리턴
    @Override
    public int getItemCount() { return mData.size(); }

    public void addItem(ItemModel item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스
    public class ViewHolder extends RecyclerView.ViewHolder {
        protected Spinner daySpinner;
        protected Spinner startTimeSpinner;
        protected Spinner finishTimeSpinner;
        protected EditText addPlace;
        protected ImageButton deleteTime;

        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조
            daySpinner = itemView.findViewById(R.id.daySpinner);
            startTimeSpinner = itemView.findViewById(R.id.startTimeSpinner);
            finishTimeSpinner = itemView.findViewById(R.id.finishTimeSpinner);
            addPlace = itemView.findViewById(R.id.addPlace);
            deleteTime = itemView.findViewById(R.id.deleteTime);
        }

    }

}
