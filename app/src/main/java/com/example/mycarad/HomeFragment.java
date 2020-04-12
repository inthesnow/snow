package com.example.mycarad;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.data.HomeData;

import java.util.ArrayList;

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

        HomeRecyclerViewAdapter advisorAdapter = new HomeRecyclerViewAdapter(dummyData1());
        advisorRecyclerView.setAdapter(advisorAdapter);

        RecyclerView carUserRecyclerView = view.findViewById(R.id.caruserRecyclerView);
        carUserRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        HomeRecyclerViewAdapter carUserAdapter = new HomeRecyclerViewAdapter(dummyData1());
        carUserRecyclerView.setAdapter(carUserAdapter);
    }

    public ArrayList<HomeData> dummyData1() {
        HomeData homeData1 = new HomeData("title1", "time1");
        HomeData homeData2 = new HomeData("title2", "time2");
        HomeData homeData3 = new HomeData("title3", "time3");
        HomeData homeData4 = new HomeData("title4", "time4");
        HomeData homeData5 = new HomeData("title5", "time5");

        ArrayList<HomeData> homeDataList = new ArrayList<>();
        homeDataList.add(homeData1);
        homeDataList.add(homeData2);
        homeDataList.add(homeData3);
        homeDataList.add(homeData4);
        homeDataList.add(homeData5);

        return homeDataList;
    }
}
