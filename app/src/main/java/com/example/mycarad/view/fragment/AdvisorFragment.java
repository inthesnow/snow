package com.example.mycarad.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.data.DummyData;
import com.example.mycarad.view.adapter.HomeRecyclerViewAdapter;

public class AdvisorFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advisor, container, false);
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView advisorRecyclerView = view.findViewById(R.id.advisorRecyclerView);
        advisorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HomeRecyclerViewAdapter advisorAdapter = new HomeRecyclerViewAdapter(DummyData.data());
        advisorRecyclerView.setAdapter(advisorAdapter);

    }
}