package com.example.ajay.concession.Fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajay.concession.Activity.MainPage;
import com.example.ajay.concession.models.Message;
import com.example.ajay.concession.R;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ajay on 1/3/2018.
 */


public class ApplyConcession extends Fragment {


    private static final String TAG="MainActivity";
    EditText roll;
    Spinner  source,dest,clss,nom;
    private TextView mDisplayDate;
    Button proceed;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_apply,container,false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        roll=(EditText) view.findViewById(R.id.rollno);
        source=(Spinner) view.findViewById(R.id.source);
        dest=(Spinner) view.findViewById(R.id.dest);
        clss=(Spinner) view.findViewById(R.id.clss);
        nom=(Spinner) view.findViewById(R.id.nom);
        mDisplayDate=(TextView) view.findViewById(R.id.dateapply);
        proceed=(Button) view.findViewById(R.id.proceed);

        SharedPreference pref = new SharedPreference(view.getContext());
        String rollno = pref.getRoll();
        roll.setText(rollno);
        roll.setEnabled(false);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year= cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day= cal.get(Calendar.DAY_OF_MONTH);
                if(month < 10){

                    month = Integer.parseInt("0" + month);
                }
                if(day < 10){

                    day  = Integer.parseInt("0" + day) ;
                }


                DatePickerDialog dialog;
                dialog = new DatePickerDialog(getContext(),android.R.style.Theme_Holo_Dialog_MinWidth,mDateSetListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                cal.add(Calendar.DATE,3);
                dialog.getDatePicker().setMaxDate(cal.getTimeInMillis());
                cal.add(Calendar.DATE, -2);
                dialog.getDatePicker().setMinDate(cal.getTimeInMillis());
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: date"+ year + "/" + month + "/" + day);

                String date= year+"-" +day +"-" +month;
                mDisplayDate.setText(date);
            }
        };


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Apply(view);
            }
            public void Apply(View view) {
                if (TextUtils.isEmpty(mDisplayDate.getText().toString())) {
                    Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_SHORT).show();
                }
                else{
                    RetrofitUtils.RetrofitService service= RetrofitUtils.getInstance();
                    Call<Message> call=service.applyconcessStud(roll.getText().toString(),source.getSelectedItem().toString(),dest.getSelectedItem().toString(),clss.getSelectedItem().toString(),nom.getSelectedItem().toString(),mDisplayDate.getText().toString());
                    call.enqueue(new Callback<Message>() {
                        @Override
                        public void onResponse(Call<Message> call, Response<Message> response) {
                            Log.e("ApplyConcession",response.toString());
                            String success= null;
                            success = response.body().getMessage();
                            Toast.makeText(getContext(), success, Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getActivity().getApplication(), MainPage.class);
                            startActivity(i);
                            getActivity().finish();
                        }

                        @Override
                        public void onFailure(Call<Message> call, Throwable t) {
                            Log.e("onFailure","Error",t);
                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        getActivity().setTitle("Apply Concession");
    }
}
