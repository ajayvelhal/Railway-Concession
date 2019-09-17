package com.example.ajay.concession.utils;

import com.example.ajay.concession.models.CancelConcess;
import com.example.ajay.concession.models.Feed;
import com.example.ajay.concession.models.RegStud;
import com.example.ajay.concession.models.Message;
import com.example.ajay.concession.models.UpdateRply;
import com.example.ajay.concession.models.User;
import com.example.ajay.concession.models.ViewConcessionStud;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Ajay on 2/2/2018.
 */
/**
 * Created by Ajay on 1/18/2018.
 */
public class RetrofitUtils {
    public static final String BASE_URL = "http://192.168.43.88:8080/";
    public static RetrofitService service = null;
    public static RetrofitService getInstance(){
        if (service == null) {
            service = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RetrofitService.class);
        }
        return service;
    }

    public interface RetrofitService {
        Call<List<RegStud>> getAllData();
        @POST("Concession/regStud.jsp")
        @FormUrlEncoded
        Call<String>regStud(
                @Field("Name") String Name,
                @Field("RollNo") String RollNo,
                @Field("DOB") String DOB,
                @Field("Address") String Address,
                @Field("Mobile") String Mobile,
                @Field("emailid") String email,
                @Field("Fee_reciept_no") String Fee_reciept_no);

        @POST("Concession/loginStud.jsp")
        @FormUrlEncoded
        Call<User>loginStud(
                @Query("RollNo") String Username,
                @Field("DOB") String Password);


        @POST("Concession/applyconcessStud.jsp")
        @FormUrlEncoded
        Call<Message> applyconcessStud(
                @Field("RollNo") String RollNo,
                @Field("Source") String Source,
                @Field("Destination") String Destination,
                @Field("Class") String Clss,
                @Field("NoOfMonths") String NoOfMonths,
                @Field("Date") String Date);

        @POST("Concession/feedbackStud.jsp")
        @FormUrlEncoded
        Call<Feed>feedbackStud(
                @Field("emailid") String Email,
                @Field("Description") String desc);


        @POST("Concession/updateStud.jsp")
        @FormUrlEncoded
        Call<UpdateRply>updateStud(
                @Field("RollNo") String roll,
                @Field("Address") String add,
                @Field("emailid") String Email);

        @GET("Concession/ViewConcessionStud.jsp")

        Call<List<ViewConcessionStud>>ViewConcessionStud(
                @Query("RollNo") String roll
        );
        @GET("Concession/viewcan.jsp")
        Call<List<CancelConcess>>viewcan(
                @Query("RollNo") String roll
        );

        @POST("Concession/CancelConcessionStud.jsp")
        @FormUrlEncoded
        Call<String>canConcess(
                @Field("RollNo") String roll
        );




    }
}
