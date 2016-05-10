package com.example.kim.episeries;

/**
 * Created by kim on 9/05/2016.
 */
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by shelajev on 16/12/15.
 */
interface DataService {
    @GET("serieData.php")
    Call<List<Serie>> seriesList();
    //void seriesList(@Query("serieName") String serieName, Callback<List<Serie>> cb);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.68.250.107:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}