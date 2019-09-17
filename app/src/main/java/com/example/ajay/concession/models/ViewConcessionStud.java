package com.example.ajay.concession.models;

import android.widget.Button;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;

import java.lang.ref.SoftReference;

/**
 * Created by Ajay on 2/2/2018.
 */

public class ViewConcessionStud {
    @SerializedName("Name") String name;
    @SerializedName("Source") String Source;
    @SerializedName("Destination") String Destination;
    @SerializedName("Clss") String Clss;
    @SerializedName("NoOfMonths") String NoOfMonths;
    @SerializedName("TokenNo") String Token;

    public ViewConcessionStud(){
        this.name=name;
        this.Source=Source;
        this.Destination=Destination;
        this.Clss=Clss;
        this.NoOfMonths=NoOfMonths;
        this.Token=Token;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        this.Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        this.Destination = destination;
    }

    public String getClss() {
        return Clss;
    }

    public void setClss(String clss) {
        this.Clss = clss;
    }

    public String getNoOfMonths() {
        return NoOfMonths;
    }

    public void setNoOfMonths(String noOfMonths) {
        this.NoOfMonths = noOfMonths;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        this.Token = token;
    }
}
