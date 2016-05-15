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


interface DataService {
    @GET("serieData.php")
    Call<List<Serie>> seriesList(@Query("serieName") String serieName);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

interface SerieService {
    @GET("serieNames.php")
    Call<List<String>> seriesList();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

interface LoginService {
    @GET("login.php")
    Call<String> getUserData(@Query("email") String email,
                                 @Query("password") String password);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

interface RegisterService {
    @GET("register.php")
    Call<String> sendUserData(@Query("email") String email,
                             @Query("password") String password);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.0.104:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}