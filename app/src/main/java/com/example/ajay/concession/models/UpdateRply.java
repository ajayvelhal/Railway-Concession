package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 2/2/2018.
 */

public class UpdateRply {

    @SerializedName("Add")private String updreply;
    public String getUpdreply(){
        return updreply;
    }

    public void setUpdreply(String updreply){
        this.updreply=updreply;
    }
}
