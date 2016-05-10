package com.example.kim.episeries;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SeriesListActivity extends AppCompatActivity {

    List<Serie> serieList = new ArrayList<Serie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Serie temp = new Serie(5, "bla", "Kim is lelijk", "if", "nu", "iei");
        serieList.add(temp);

        RecyclerView recList = (RecyclerView) findViewById(R.id.series_list);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SerieAdapter seriesAdapter = new SerieAdapter(serieList);
        recList.setAdapter(seriesAdapter);

    }

}
