package com.example.kim.episeries;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SerieActivity extends AppCompatActivity {

    List<Serie> serieList = new ArrayList<Serie>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie);

        DataService dataService = DataService.retrofit.create(DataService.class);
        Bundle extras = getIntent().getExtras();
        String seriee = extras.getString("serieName");
        final Call<List<Serie>> call =
                dataService.seriesList(seriee);

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
        RecyclerView recList = (RecyclerView) findViewById(R.id.episodes_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SerieAdapter seriesAdapter = new SerieAdapter(list);
        recList.setAdapter(seriesAdapter);


    }
}
