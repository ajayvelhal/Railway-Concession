package com.example.ajay.concession.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.ajay.concession.R;

public class Welcome extends AppCompatActivity {
    LinearLayout l1,l2;
    Button signin;
    Button signup;
    Animation uptodown,downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        signin=(Button) findViewById(R.id.btnsignin);
        signup=(Button) findViewById(R.id.btnsignup);
        l1=(LinearLayout) findViewById(R.id.l1);
        l2=(LinearLayout) findViewById(R.id.l2);
        uptodown= AnimationUtils.loadAnimation(this,R.anim.uptodown);
        l1.setAnimation(uptodown);
        downtoup=AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l2.setAnimation(downtoup);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Welcome.this,Login.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Welcome.this,Register.class);
                startActivity(intent);
            }
        });
    }
}
