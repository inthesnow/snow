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
import com.example.mycarad.view.activity.HomeActivity;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HomeData> list;

    public HomeRecyclerViewAdapter(Context context, ArrayList<HomeData> homeDataList) {
        this.context = context;
        this.list = homeDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.home_recycleview_item, parent, false);
        HomeRecyclerViewAdapter.ViewHolder  vh = new HomeRecyclerViewAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(HomeData home) {
            TextView tv1 = itemView.findViewById(R.id.titleTextView);
            tv1.setText(home.getTitle());

            TextView tv2 = itemView.findViewById(R.id.timeTextView);
            tv2.setText(home.getTime());

            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "눌렸다!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, HomeActivity.class);
                    context.startActivity(intent);
                }
            });

        }


    }
}
