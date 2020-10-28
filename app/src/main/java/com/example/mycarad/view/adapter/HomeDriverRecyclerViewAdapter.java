package com.example.mycarad.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

public class HomeDriverRecyclerViewAdapter extends RecyclerView.Adapter<HomeDriverRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DriverBoardInfo> list;
    private String userName;

    public HomeDriverRecyclerViewAdapter(Context context, List<DriverBoardInfo> driverDataList, String userName) {
        this.context = context;
        this.list = (ArrayList<DriverBoardInfo>) driverDataList;
        this.userName = userName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_recycleview_item, parent, false);
        HomeDriverRecyclerViewAdapter.ViewHolder vh = new HomeDriverRecyclerViewAdapter.ViewHolder(view);

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
            TextView tv1 = itemView.findViewById(R.id.titleTextView);
            tv1.setText(driver.getTitle());

            TextView tv2 = itemView.findViewById(R.id.timeTextView);
            tv2.setText(driver.getDate());

            tv1.setOnClickListener(view -> {
                Intent intent = new Intent(context, DriverViewActivity.class);
                Bundle extras = new Bundle();
                extras.putString("idx", driver.getIdx());
                extras.putString("test", userName);
                intent.putExtras(extras);
                context.startActivity(intent);
            });

        }


    }
}