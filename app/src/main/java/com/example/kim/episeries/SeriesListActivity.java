package com.example.kim.episeries;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class SeriesListActivity extends AppCompatActivity {

    List<Serie> serieList = new ArrayList<Serie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DataService dataService = DataService.retrofit.create(DataService.class);
        String seriee = "Arrow";
        final Call<List<Serie>> call =
                dataService.seriesList(seriee);

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



        //final Serie temp = new Serie(5, "bla", "Kim is lelijk", "if", "nu", "iei");
        //serieList.add(temp);



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
