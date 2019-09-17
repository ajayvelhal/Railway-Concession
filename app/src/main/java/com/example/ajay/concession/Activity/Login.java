package com.example.ajay.concession.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajay.concession.R;
import com.example.ajay.concession.utils.RetrofitUtils;
import com.example.ajay.concession.utils.SharedPreference;
import com.example.ajay.concession.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ajay on 1/2/2018.
 */

public class Login extends AppCompatActivity {

    Button btnsign;
    EditText uname,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        btnsign= (Button) findViewById(R.id.login);
        uname=(EditText) findViewById(R.id.uname);
        pwd=(EditText) findViewById(R.id.pswd);

        btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitUtils.RetrofitService service= RetrofitUtils.getInstance();
                Call<User> call=service.loginStud(uname.getText().toString(),pwd.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.e("Register",response.toString());
                        User u = response.body();
                        if (!u.getName().equals("0")){
                            SharedPreference pref = new SharedPreference(Login.this);
                            pref.setRoll(u.getRoll() + "");
                            pref.setName(u.getName());
                            pref.setEmail(u.getEmail());
                            pref.setAdd(u.getAdd());
                            Intent intent=new Intent(Login.this,MainPage.class);
                            startActivity(intent);
                            finish();

                            //Toast.makeText(Login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(Login.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e("onFailure","Error",t);
                        Toast.makeText(Login.this, "Failed", Toast.LENGTH_SHORT).show();
                    }

            });
        }
    });

    }
    //public void onBackPressed(){
      //  moveTaskToBack(false);
    //}

}

