package com.example.kim.episeries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AddSerieActivity extends AppCompatActivity {

    public static Context context;
    List<String> serieList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SerieService serieService = SerieService.retrofit.create(SerieService.class);
        final Call<List<String>> call =
                serieService.seriesList();

                                //new NetworkCall().execute(call);
        /*call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Response<List<String>> response, Retrofit retrofit) {
                for(final String tempserie : response.body()){
                    Log.w("SUCCES", tempserie.toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("ERROR: ", t.toString());
                Log.w("ERROR: ", t.getMessage());
                Log.w("ERROR: ", t.getLocalizedMessage());
                Log.w("ERROR: ", t.getCause().toString());
            }
        });*/


        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Response<List<String>> response, Retrofit retrofit) {
                for (final String seriename : response.body()){
                    Log.w("Serie: ", seriename);
                    serieList.add(seriename);
                }
                updateView(serieList);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("faal", t.toString());
            }
        });

    }

    public void updateView(List<String> list) {
        final RecyclerView recList = (RecyclerView) findViewById(R.id.add_series_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SerieNameAdapter seriesAdapter = new SerieNameAdapter(list,getBaseContext());
        recList.setAdapter(seriesAdapter);


    }


}
