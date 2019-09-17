package com.example.ajay.concession.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajay.concession.Activity.MainPage;
import com.example.ajay.concession.models.Feed;
import com.example.ajay.concession.R;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 1/3/2018.
 */

public class Feedback extends Fragment {

    EditText email, desc;


    Button submit, clear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("FeedBack");


        email = view.findViewById(R.id.emailid);
        desc = view.findViewById(R.id.feed);
        submit = view.findViewById(R.id.send);
        clear = view.findViewById(R.id.clear);

        final SharedPreference pref = new SharedPreference(view.getContext());
        String emailid=pref.getEmail();
        email.setText(emailid);
        email.setEnabled(false);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desc.setText("");
            }
        });

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               GiveFeedback(view);
           }
           public void GiveFeedback(View view) {
               if (TextUtils.isEmpty(desc.getText().toString())) {
                   desc.setError("Description can't be blank");
                   return;
               }else{
                   RetrofitUtils.RetrofitService service= RetrofitUtils.getInstance();
                   Call<Feed> call=service.feedbackStud(email.getText().toString(),desc.getText().toString());
                   call.enqueue(new Callback<Feed>() {
                       @Override
                       public void onResponse(Call<Feed> call, Response<Feed> response) {
                           Log.e("Feedback", response.toString());
                           String success = null;
                           success = response.body().getReply();
                           Toast.makeText(getContext(), success, Toast.LENGTH_SHORT).show();
                           Intent i = new Intent(getActivity().getApplication(), MainPage.class);
                           startActivity(i);
                           getActivity().finish();
                       }

                       @Override
                       public void onFailure(Call<Feed> call, Throwable t) {
                           Log.e("onFailure", "Error", t);
                           Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                       }
                   });

               }
           }
       });

    }
}

