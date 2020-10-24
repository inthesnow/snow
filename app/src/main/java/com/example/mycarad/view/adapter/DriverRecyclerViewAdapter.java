package com.example.mycarad.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.data.DriverBoardInfo;
import com.example.mycarad.view.activity.DriverViewActivity;

import java.util.ArrayList;
import java.util.List;

public class DriverRecyclerViewAdapter extends RecyclerView.Adapter<DriverRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DriverBoardInfo> list;

    public DriverRecyclerViewAdapter(Context context, List<DriverBoardInfo> driverDataList) {
        this.context = context;
        this.list = (ArrayList<DriverBoardInfo>) driverDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_driver, parent, false);
        DriverRecyclerViewAdapter.ViewHolder vh = new DriverRecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(DriverBoardInfo driver) {
            TextView tv1 = itemView.findViewById(R.id.driverTitleTextView);
            tv1.setText(driver.getTitle());

            TextView tv2 = itemView.findViewById(R.id.driverTimeTextView);
            tv2.setText(driver.getDate());

            TextView tv3 = itemView.findViewById(R.id.driverAreaTextView);
            tv3.setText(driver.getIdx() + "/" + driver.getUserName()); //TODO: 인덱스, 유저네임 -> 지역, 차종으로 수정

            tv1.setOnClickListener(view -> {
                Intent intent = new Intent(context, DriverViewActivity.class);
                context.startActivity(intent);
            });

        }


    }
}