package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/28/2018.
 */

public class Message {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")private String message;
}
