package com.example.ajay.concession.models;

import com.example.ajay.concession.R;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 2/2/2018.
 */

public class updateStud {
    @SerializedName("RollNo") String roll;
    @SerializedName("emailid") String Email;
    @SerializedName("Address") String Add;

    public updateStud(String roll,String Email, String Add){
        this.Email=Email;
        this.Add=Add;
        this.roll=roll;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        this.Add = add;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
}
