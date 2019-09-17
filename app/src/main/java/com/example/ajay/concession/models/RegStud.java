package com.example.ajay.concession.models;

import android.provider.Telephony;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/19/2018.
 */

public class RegStud {

    @SerializedName("id")private String ID;
    @SerializedName("name") private String name;
    @SerializedName("RollNo") private String RollNo;
    @SerializedName("dob") private String dob;
    @SerializedName("Address") private String Address;
    @SerializedName("Mobile") private String Mobile;
    @SerializedName("email") private String email;

    public RegStud(String ID,String Name,String RollNo,String dob,String Address,String Mobile,String email){
        this.ID=ID;
        this.name=name;
        this.RollNo=RollNo;
        this.dob=dob;
        this.Address= Address;
        this.Mobile=Mobile;
        this.email=email;
    }

    public String getID(){
        return ID;
    }
    public void setID(String ID){
        this.ID=ID;
    }
    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name=name;
    }
    public String getRollNo(){
        return RollNo;
    }

    public void setRollNo(String RollNo) {
        this.Address=Address;
    }

    public String getDob(){
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getMobile(){
        return Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
