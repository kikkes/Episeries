package com.example.kim.episeries;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kim on 10/05/2016.
 */
public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.SerieViewHolder> {
        private List<Serie> serieList;

        public SerieAdapter(List<Serie> serieList) {
            this.serieList = serieList;
        }


        @Override
        public int getItemCount() {
            return serieList.size();
        }

        @Override
        public void onBindViewHolder(SerieViewHolder serieViewHolder, int i) {
            Serie serie = serieList.get(i);
            serieViewHolder.vEpiName.setText(serie.getEpiName());
            serieViewHolder.vReleaseDate.setText(serie.getReleaseDate());
            serieViewHolder.vSeason.setText(serie.getSeason());
            serieViewHolder.vSerieName.setText(serie.getSerieName());
            serieViewHolder.vEpisode.setText(serie.getEpisode());
        }

        @Override
        public SerieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.seriecard, viewGroup, false);

            return new SerieViewHolder(itemView);
        }

        public static class SerieViewHolder extends RecyclerView.ViewHolder {
            protected TextView vEpiName;
            protected TextView vReleaseDate;
            protected TextView vSeason;
            protected TextView vSerieName;
            protected TextView vEpisode;

            public SerieViewHolder(View v) {
                super(v);
                vEpiName = (TextView) v.findViewById(R.id.txtEpiName);
                vReleaseDate =  (TextView) v.findViewById(R.id.txtReleaseDate);
                vSeason = (TextView)  v.findViewById(R.id.txtSeason);
                vSerieName = (TextView)  v.findViewById(R.id.txtSerieName);
                vEpisode = (TextView) v.findViewById(R.id.txtEpisode);
            }
        }
    }
