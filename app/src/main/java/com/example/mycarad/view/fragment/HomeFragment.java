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
import com.example.mycarad.view.adapter.HomeAdvisorRecyclerViewAdapter;
import com.example.mycarad.view.adapter.HomeDriverRecyclerViewAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends Fragment {

    RecyclerView homeDriverRecyclerView;
    RecyclerView homeAdvisorRecyclerView;

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
        homeDriverRecyclerView = view.findViewById(R.id.homeDriverRecyclerView);
        homeDriverRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getDriverBoardList();
        homeAdvisorRecyclerView = view.findViewById(R.id.homeAdvisorRecyclerView);
        homeAdvisorRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getAdvisorBoardList();

    }
    @SuppressLint("CheckResult")
    private void getDriverBoardList() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getDriverBoardList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    HomeDriverRecyclerViewAdapter homeDriverAdapter = new HomeDriverRecyclerViewAdapter(getContext(), response.getResponse(), "test");
                    homeDriverRecyclerView.setAdapter(homeDriverAdapter);
                });

    }

    @SuppressLint("CheckResult")
    private void getAdvisorBoardList() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getAdvisorBoardList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    HomeAdvisorRecyclerViewAdapter homeAdvisorAdapter = new HomeAdvisorRecyclerViewAdapter(getContext(), response.getResponse(), "test");
                    homeAdvisorRecyclerView.setAdapter(homeAdvisorAdapter);
                });

    }
}
