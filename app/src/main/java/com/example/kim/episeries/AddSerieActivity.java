package com.example.kim.episeries;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AddSerieActivity extends AppCompatActivity {

    List<Serie> serieList = new ArrayList<Serie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SerieService serieService = SerieService.retrofit.create(SerieService.class);
        final Call<List<Serie>> call =
                serieService.seriesList();

                                //new NetworkCall().execute(call);



        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Response<List<Serie>> response, Retrofit retrofit) {
                for (final Serie tempserie : response.body()){
                    Log.w("Serie: ", tempserie.toString());
                    serieList.add(tempserie);
                }
                updateView(serieList);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("faal", t.toString());
            }
        });
    }

    public void updateView(List<Serie> list) {
        RecyclerView recList = (RecyclerView) findViewById(R.id.series_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SerieAdapter seriesAdapter = new SerieAdapter(list);
        recList.setAdapter(seriesAdapter);


    }


}
