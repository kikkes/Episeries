package com.example.kim.episeries;

/**
 * Created by kim on 9/05/2016.
 */
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;

/**
 * Created by shelajev on 16/12/15.
 */
interface DataService {
    @GET("famapp/test.php")
    Call<List<Serie>> seriesList();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.68.246.147:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}