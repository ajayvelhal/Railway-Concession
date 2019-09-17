package com.example.ajay.concession.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajay.concession.R;
import com.example.ajay.concession.utils.RetrofitUtils;

import java.util.Calendar;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 1/2/2018.
 */

public class Register extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    //private AwesomeValidation awesomeValidation;
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button reg;
    EditText fee_reciept_no, name, roll, address, mob, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        name = (EditText) findViewById(R.id.name);
        roll = (EditText) findViewById(R.id.roll);
        mDisplayDate = (EditText) findViewById(R.id.dob);

        address = (EditText) findViewById(R.id.add);
        mob = (EditText) findViewById(R.id.mob);
        email = (EditText) findViewById(R.id.email);
        fee_reciept_no = (EditText) findViewById(R.id.fee_reciept_no);
        reg = (Button) findViewById(R.id.reg);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Register.this, android.R.style.Theme_Holo_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date" + year + "/" + month + "/" + dayOfMonth);

                String date = dayOfMonth + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        // awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        //awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        //awesomeValidation.addValidation(this, R.id.mob, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        // }

        //  private void submit(){
        // if (awesomeValidation.validate()) {
        //  Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();
        //}

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertToDatabase(view);
            }

            private void InsertToDatabase(View view) {
                if (TextUtils.isEmpty(name.getText().toString())) {
                    name.setError("Enter name");
                    return;
                }
                if (!name.getText().toString().matches("[a-zA-Z ]+")) {
                    name.requestFocus();
                    name.setError("ENTER ONLY ALPHABETICAL CHARACTER");
                }
                if (TextUtils.isEmpty(roll.getText().toString())) {
                    roll.setError("Enter RollNo");
                    return;
                }

                if (!roll.getText().toString().matches("[0-9]+")) {
                    roll.requestFocus();
                    roll.setError("ENTER ONLY NUMERICAL CHARACTER");
                }
                if ((roll.getText().length() < 4) || (roll.getText().length() > 4)) {
                    Toast.makeText(Register.this, "Enter Valid RollNo! ", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(mDisplayDate.getText().toString())) {
                    mDisplayDate.setError("Enter DOB");
                    return;
                }
                if (TextUtils.isEmpty(address.getText().toString())) {
                    address.setError("Enter Address");
                    return;
                }
                if (TextUtils.isEmpty(mob.getText().toString())) {
                    mob.setError("Enter Contact-");
                    return;
                }
                if (!mob.getText().toString().matches("[789][0-9]\\d{8}$") || (mob.getText().length()<10)) {
                    mob.requestFocus();
                    mob.setError("ENTER VALID CONTACT NUMBER");
                }
                if (TextUtils.isEmpty(email.getText().toString())) {
                    email.setError("Enter EmailID");
                    return;
                }
                Pattern pattern = Pattern.compile("(?:[a-z0-9._]+)@(?:[a-z])+.(?:[a-z])+");
                if(!pattern.matcher(email.getText().toString()).matches()){
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                /*if (!email.toString().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                    Toast.makeText(getApplicationContext(), "Enter valid email address", Toast.LENGTH_SHORT).show();
                }*/
                if (!fee_reciept_no.getText().toString().matches("[0-9]+")) {
                    fee_reciept_no.requestFocus();
                    fee_reciept_no.setError("ENTER ONLY NUMERICAL CHARACTER");
                } else {
                    RetrofitUtils.RetrofitService service = RetrofitUtils.getInstance();
                    Call<String> call = service.regStud(name.getText().toString(), roll.getText().toString(), mDisplayDate.getText().toString(), address.getText().toString(), mob.getText().toString(), email.getText().toString(), fee_reciept_no.getText().toString());
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            Log.e("Register", response.toString());
                            String success = response.body();
                            if (success.equals("1")) {
                                // submit();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.e("Error", t.toString());
                            Toast.makeText(Register.this, "Failed", Toast.LENGTH_SHORT).show();
                        }


                    });


                }
            }

        });
    }
}