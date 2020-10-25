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
import com.example.mycarad.data.AdvisorBoardInfo;
import com.example.mycarad.data.AdvisorData;
import com.example.mycarad.view.activity.AdvisorViewActivity;
import com.example.mycarad.view.activity.HomeActivity;

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

        public void bind(AdvisorBoardInfo Advisor) {
            TextView tv1 = itemView.findViewById(R.id.advTitleTextView);
            tv1.setText(Advisor.getTitle());

            TextView tv2 = itemView.findViewById(R.id.advTimeTextView);
            tv2.setText(Advisor.getDate());

            TextView tv3 = itemView.findViewById(R.id.advAreaTextView);
            tv3.setText(Advisor.getArea() + "/" + Advisor.getMoney());


            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "눌렸다!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, AdvisorViewActivity.class);
                    context.startActivity(intent);
                }
            });

        }


    }
}
