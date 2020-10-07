package com.example.mycarad.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.data.DummyData;
import com.example.mycarad.view.adapter.HomeRecyclerViewAdapter;

public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView advisorRecyclerView = view.findViewById(R.id.advisorRecyclerView);
        advisorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HomeRecyclerViewAdapter advisorAdapter = new HomeRecyclerViewAdapter(getContext(), DummyData.data());
        advisorRecyclerView.setAdapter(advisorAdapter);

        RecyclerView carUserRecyclerView = view.findViewById(R.id.caruserRecyclerView);
        carUserRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HomeRecyclerViewAdapter carUserAdapter = new HomeRecyclerViewAdapter(getContext(), DummyData.data());
        carUserRecyclerView.setAdapter(carUserAdapter);

        Button goToAdvisorButton = view.findViewById(R.id.advisorNavi);
        goToAdvisorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "눌렸다", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
