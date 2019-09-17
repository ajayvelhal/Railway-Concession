package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/30/2018.
 */

public class feedStud {

    @SerializedName("emailid") String Email;
    @SerializedName("Description") String desc;

    public feedStud(String Email, String desc){

        this.Email=Email;
        this.desc=desc;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
