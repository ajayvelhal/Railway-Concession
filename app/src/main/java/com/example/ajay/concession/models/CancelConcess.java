package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 2/7/2018.
 */

public class CancelConcess {
    @SerializedName("RollNo") String Roll;
    @SerializedName("date") String date;
    @SerializedName("token") String token;

    public  CancelConcess(String Roll,String date,String token){
        this.Roll=Roll;
        this.date=date;
        this.token=token;
    }

    public String getRoll() {
        return Roll;
    }

    public void setRoll(String roll) {
        this.Roll = roll;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
