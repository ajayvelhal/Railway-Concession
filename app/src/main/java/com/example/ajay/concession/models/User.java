package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/28/2018.
 */

public class User {
    @SerializedName("rollno")private int roll;
    @SerializedName("name")private String name;
    @SerializedName("emailid") private String Email;
    @SerializedName("address") private String Add;

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email=Email;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        this.Add = add;
    }
}
