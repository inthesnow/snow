package com.example.mycarad.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.data.AdvisorBoardInfo;
import com.example.mycarad.view.activity.AdvisorViewActivity;

import java.util.ArrayList;
import java.util.List;

public class AdvisorRecyclerViewAdapter extends RecyclerView.Adapter<AdvisorRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AdvisorBoardInfo> list;

    public AdvisorRecyclerViewAdapter(Context context, List<AdvisorBoardInfo> advisorDataList) {
        this.context = context;
        this.list = (ArrayList<AdvisorBoardInfo>) advisorDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_advisor, parent, false);
        AdvisorRecyclerViewAdapter.ViewHolder  vh = new AdvisorRecyclerViewAdapter.ViewHolder(view);

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

        public void bind(AdvisorBoardInfo advisorInfo) {
            TextView tv1 = itemView.findViewById(R.id.advTitleTextView);
            tv1.setText(advisorInfo.getTitle());

            TextView tv2 = itemView.findViewById(R.id.advTimeTextView);
            tv2.setText(advisorInfo.getDate());

            TextView tv3 = itemView.findViewById(R.id.advAreaTextView);
            tv3.setText(advisorInfo.getArea() + "/" + advisorInfo.getMoney());

            ConstraintLayout advisorItemLayout = itemView.findViewById(R.id.advisorItemLayout);
            advisorItemLayout.setOnClickListener(v -> {
                Intent intent = new Intent(context, AdvisorViewActivity.class);
                Log.e("ayhan", "advisorInfo.getIdx() : " + advisorInfo.getIdx());

                Bundle extras = new Bundle();
                extras.putString("writeId", advisorInfo.getIdx());
                intent.putExtras(extras);

                context.startActivity(intent);
            });
        }


    }
}
