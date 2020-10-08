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
import com.example.mycarad.data.DriverDummyData;
import com.example.mycarad.view.adapter.DriverRecyclerViewAdapter;

public class DriverFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_driver, container, false);
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView driverRecyclerView = view.findViewById(R.id.driverRecyclerView);
        driverRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DriverRecyclerViewAdapter driverAdapter = new DriverRecyclerViewAdapter(getContext(), DriverDummyData.data());
        driverRecyclerView.setAdapter(driverAdapter);

    }
}