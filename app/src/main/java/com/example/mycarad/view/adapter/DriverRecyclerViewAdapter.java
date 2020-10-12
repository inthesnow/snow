package com.example.mycarad.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.data.DriverData;
import com.example.mycarad.view.activity.DriverViewActivity;
import com.example.mycarad.view.activity.HomeActivity;

import java.util.ArrayList;

public class DriverRecyclerViewAdapter extends RecyclerView.Adapter<DriverRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<DriverData> list;

    public DriverRecyclerViewAdapter(Context context, ArrayList<DriverData> DriverDataList) {
        this.context = context;
        this.list = DriverDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_driver, parent, false);
        DriverRecyclerViewAdapter.ViewHolder  vh = new DriverRecyclerViewAdapter.ViewHolder(view);

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

        public void bind(DriverData Driver) {
            TextView tv1 = itemView.findViewById(R.id.driverTitleTextView);
            tv1.setText(Driver.getTitle());

            TextView tv2 = itemView.findViewById(R.id.driverTimeTextView);
            tv2.setText(Driver.getTime());

            TextView tv3 = itemView.findViewById(R.id.driverAreaTextView);
            tv3.setText(Driver.getArea() + "/" + Driver.getCarKind());

            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DriverViewActivity.class);
                    context.startActivity(intent);
                }
            });

        }


    }
}
