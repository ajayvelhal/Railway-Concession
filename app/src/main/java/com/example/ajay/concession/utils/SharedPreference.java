package com.example.ajay.concession.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ajay on 1/28/2018.
 */

public class SharedPreference {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    int Private_mode=0;

    private static final String pref_name="Roll";
    private static  final String ROLL_KEY = "Roll";
    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY= "email";
    private static final String Add_KEY= "address";

    public SharedPreference(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences(pref_name,Private_mode);
        editor=sharedPreferences.edit();
    }

    public void setRoll(String Roll){
        editor.putString(ROLL_KEY,Roll);
        editor.commit();
    }

    public String getRoll(){

        return sharedPreferences.getString(ROLL_KEY,null);
    }

    public void setName(String name) {
        editor.putString(NAME_KEY, name);
        editor.commit();
    }

    public String getName() {

        return sharedPreferences.getString(NAME_KEY,null);
    }

    public  String getEmail() {
        return sharedPreferences.getString(EMAIL_KEY,null);
    }
    public void setEmail(String email){
        editor.putString(EMAIL_KEY, email);
        editor.commit();
    }

    public  String getAdd()
    {
        return sharedPreferences.getString(Add_KEY,null);
    }

    public void setAdd(String add){
        editor.putString(Add_KEY,add);
        editor.commit();
    }
}

