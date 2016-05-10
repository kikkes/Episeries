package com.example.kim.episeries;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class AddSerieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_serie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DataService dataService = DataService.retrofit.create(DataService.class);
        String piet = "Arrow";
        final Call<List<Serie>> call =
                dataService.seriesList();

                                //new NetworkCall().execute(call);



        call.enqueue(new Callback<List<Serie>>() {
            @Override
            public void onResponse(Response<List<Serie>> response, Retrofit retrofit) {
                for (final Serie tempserie : response.body()){
                    Log.w("Serie: ", tempserie.toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.w("faal", t.toString());
            }
        });
    }




    /*private class NetworkCall extends AsyncTask<Call, Void, String> {
        @Override
        protected String doInBackground(Call... params) {
            try {
                return params[0].execute().body().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            final TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(result);
        }
    }*/

}
