package com.example.mycarad.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycarad.R;
import com.example.mycarad.server.ApiClient;
import com.example.mycarad.server.RetrofitInterface;
import com.example.mycarad.view.adapter.AdvisorRecyclerViewAdapter;
import com.example.mycarad.view.adapter.DriverRecyclerViewAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AdvisorFragment extends Fragment {

    private RecyclerView advisorRecyclerView;

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
        advisorRecyclerView = view.findViewById(R.id.advisorRecyclerView);
        advisorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        getAdvisorBoardList();
    }

    @SuppressLint("CheckResult")
    private void getAdvisorBoardList() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getAdvisorBoardList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    AdvisorRecyclerViewAdapter advisorAdapter = new AdvisorRecyclerViewAdapter(getContext(), response.getResponse());
                    advisorRecyclerView.setAdapter(advisorAdapter);
                });

    }
}