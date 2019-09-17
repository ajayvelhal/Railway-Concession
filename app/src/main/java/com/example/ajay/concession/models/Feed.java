package com.example.ajay.concession.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ajay on 1/30/2018.
 */

public class Feed {

    public String getReply() {
        return Reply;
    }

    public void setReply(String Reply) {
        this.Reply = Reply;
    }

    @SerializedName("Feed")private String Reply;
}
