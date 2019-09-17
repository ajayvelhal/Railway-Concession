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
import com.example.ajay.concession.R;
import com.example.ajay.concession.models.UpdateRply;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 1/3/2018.
 */

public class Update extends Fragment {
    EditText roll,address,email;
    Button updsub,updclear;
    SharedPreference pref;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_update,container,false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Update Details");

        roll=(EditText) view.findViewById(R.id.updroll);
        address=(EditText) view.findViewById(R.id.updadd);
        email=(EditText) view.findViewById(R.id.updemail);
        updsub=(Button) view.findViewById(R.id.updsend);
        updclear=(Button) view.findViewById(R.id.updclear);

        pref = new SharedPreference(view.getContext());
        roll.setText(pref.getRoll());
        roll.setEnabled(false);
        address.setText(pref.getAdd());




        updclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                address.setText("");
                email.setText("");
            }
        });

        updsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData(view);
            }
            public void UpdateData(View view){
                    if (TextUtils.isEmpty(email.getText().toString())) {
                        email.setError("Enter EmailID");
                        return;
                    }
                Pattern pattern = Pattern.compile("(?:[a-z0-9._]+)@(?:[a-z])+.(?:[a-z])+");
                if(!pattern.matcher(email.getText().toString()).matches()){
                    Toast.makeText(getContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                        Log.e("roll",roll.getText().toString());
                        RetrofitUtils.RetrofitService service= RetrofitUtils.getInstance();
                        Call<UpdateRply> call=service.updateStud(roll.getText().toString(),address.getText().toString(),email.getText().toString());
                        call.enqueue(new Callback<UpdateRply>() {
                            @Override
                            public void onResponse(Call<UpdateRply> call, Response<UpdateRply> response) {
                                Log.e("Feedback",response.toString());

                                String success=response.body().getUpdreply();
                                Toast.makeText(getContext(),success, Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getActivity().getApplication(), MainPage.class);
                                startActivity(i);
                                getActivity().finish();
                            }

                            @Override
                            public void onFailure(Call<UpdateRply> call, Throwable t) {
                                Log.e("onFailure","Error",t);
                                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                    }



        });
    }
}
