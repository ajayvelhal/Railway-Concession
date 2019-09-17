package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/23/2018.
 */

public class loginStud {

    @SerializedName("uname")private String Username;
    @SerializedName("pswd") private String Password;

    public loginStud(String username, String password) {
        this.Username=Username;
        this.Password=Password;
    }

    public String getUsername(){
        return Username;
    }
    public void setUsername(String Username){
        this.Username=Username;
    }
    public String getPassword(){

        return Password;
    }
    public void setPassword(String Password){

        this.Password=Password;
    }
}
