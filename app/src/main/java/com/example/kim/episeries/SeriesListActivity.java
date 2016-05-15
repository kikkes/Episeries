package com.example.kim.episeries;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SeriesListActivity extends AppCompatActivity {

    public static Context context;
    List<String> serieList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final SerieService serieService = SerieService.retrofit.create(SerieService.class);
        final Call<List<String>> call =
                serieService.seriesList();


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
        final RecyclerView recList = (RecyclerView) findViewById(R.id.series_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SerieNameAdapter seriesAdapter = new SerieNameAdapter(list,getBaseContext());
        recList.setAdapter(seriesAdapter);


    }

}
