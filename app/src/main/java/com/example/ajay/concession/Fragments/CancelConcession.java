package com.example.ajay.concession.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ajay.concession.Activity.MainPage;
import com.example.ajay.concession.R;
import com.example.ajay.concession.adapter.ListViewAdapter;
import com.example.ajay.concession.adapter.ViewConcessionAdapter;
import com.example.ajay.concession.models.CancelConcess;
import com.example.ajay.concession.models.ViewConcessionStud;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 1/3/2018.
 */

public class CancelConcession extends Fragment {
    View view;
    RecyclerView rvStatus;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_cancel,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Cancel Concession");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rvStatus = view.findViewById(R.id.rvCancel);
        SharedPreference pref = new SharedPreference(getContext());

        RetrofitUtils.RetrofitService service = RetrofitUtils.getInstance();
        service.viewcan(pref.getRoll()).enqueue(new Callback<List<CancelConcess>>() {
            @Override
            public void onResponse(Call<List<CancelConcess>> call, Response<List<CancelConcess>> response) {
                List<CancelConcess> listcan =  response.body();

                rvStatus.setLayoutManager(new LinearLayoutManager(CancelConcession.this.getActivity()));
                rvStatus.setAdapter(new ListViewAdapter((ArrayList<CancelConcess>) listcan ));


            }

            @Override
            public void onFailure(Call<List<CancelConcess>> call, Throwable t) {
                Log.e("onFailure","Error",t);
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
