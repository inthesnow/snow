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
import com.example.mycarad.view.adapter.DriverRecyclerViewAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DriverFragment extends Fragment {

    RecyclerView driverRecyclerView;

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
        driverRecyclerView = view.findViewById(R.id.driverRecyclerView);
        driverRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getDriverBoardList();

    }

    @SuppressLint("CheckResult")
    private void getDriverBoardList() {
        RetrofitInterface retrofitInterface = ApiClient.getClient().create(RetrofitInterface.class);
        retrofitInterface.getDriverBoardList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    DriverRecyclerViewAdapter driverAdapter = new DriverRecyclerViewAdapter(getContext(), response.getResponse(), "test");
                    driverRecyclerView.setAdapter(driverAdapter);
                });

    }
}
