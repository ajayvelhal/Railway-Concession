package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

import static android.os.Build.ID;

/**
 * Created by Ajay on 1/27/2018.
 */

public class ApplyConcess {
    @SerializedName("RollNo")private String RollNo;
    @SerializedName("Source") private String Source;
    @SerializedName("Destination") private String Destination ;
    @SerializedName("Clss") private String Clss;
    @SerializedName("NoOfMonths") private String NoOfMonths;
    @SerializedName("Date") private String Date;


    public ApplyConcess(String RollNo ,String Source,String Destination,String Clss,String NoOfMonths,String Date){
        this.RollNo=RollNo;
        this.Source=Source;
        this.Destination=Destination;
        this.Clss=Clss;
        this.NoOfMonths= NoOfMonths;
        this.Date=Date;
    }

    public String getRollNo(){
        return RollNo;
    }
    public void setRollNo(String ID){
        this.RollNo=RollNo;
    }

    public String getSource(){
        return Source;
    }
    public void setSource(String Source){
        this.Source=Source;
    }

    public String getDestination(){
        return Destination;
    }
    public void setDestination(String Destination){
        this.Destination=Destination;
    }

    public String getClss(){
        return Clss;
    }
    public void setClss(String Clss){
        this.Clss=Clss;
    }

    public String getNoOfMonths(){
        return NoOfMonths;
    }
    public void setNoOfMonths(String NoOfMonths){
        this.NoOfMonths=NoOfMonths;
    }

    public String getDate(){
        return Date;
    }
    public void setDate(String Date){
        this.Date=Date;
    }
}
