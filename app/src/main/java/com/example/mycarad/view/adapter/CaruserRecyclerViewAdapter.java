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
import com.example.mycarad.data.CaruserData;
import com.example.mycarad.view.activity.HomeActivity;

import java.util.ArrayList;

public class CaruserRecyclerViewAdapter extends RecyclerView.Adapter<CaruserRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<CaruserData> list;

    public CaruserRecyclerViewAdapter(Context context, ArrayList<CaruserData> CaruserDataList) {
        this.context = context;
        this.list = CaruserDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_caruser, parent, false);
        CaruserRecyclerViewAdapter.ViewHolder  vh = new CaruserRecyclerViewAdapter.ViewHolder(view);

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

        public void bind(CaruserData Caruser) {
            TextView tv1 = itemView.findViewById(R.id.caruserTitleTextView);
            tv1.setText(Caruser.getTitle());

            TextView tv2 = itemView.findViewById(R.id.caruserTimeTextView);
            tv2.setText(Caruser.getTime());

            TextView tv3 = itemView.findViewById(R.id.caruserAreaTextView);
            tv3.setText(Caruser.getArea());

            TextView tv4 = itemView.findViewById(R.id.caruserCarnameTextView);
            tv4.setText(Caruser.getCarKind());

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
