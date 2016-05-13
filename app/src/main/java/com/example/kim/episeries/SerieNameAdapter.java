package com.example.kim.episeries;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kim on 10/05/2016.
 */
public class SerieNameAdapter extends RecyclerView.Adapter<SerieNameAdapter.SerieViewHolder> {
    private List<String> serieList;
    Context adaptercontext;

    public SerieNameAdapter(List<String> serieList, Context context) {
        this.serieList = serieList;
        this.adaptercontext = context;
    }


    @Override
    public int getItemCount() {
        return serieList.size();
    }

    @Override
    public void onBindViewHolder(SerieViewHolder serieViewHolder, int i) {
        String serie = serieList.get(i);
        serieViewHolder.vSerieName.setText(serie);
        serieViewHolder.bind(adaptercontext);

    }


    @Override
    public SerieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.serienamecard, viewGroup, false);
        return new SerieViewHolder(itemView);
    }

    public class SerieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView vSerieName;
        private Context context;

        public SerieViewHolder(View v) {
            super(v);
            vSerieName = (TextView)  v.findViewById(R.id.txtSerieName);
            vSerieName.setOnClickListener(this);

        }

        public void bind(final Context context) {
          this.context = context;
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.txtSerieName:
                    String str = vSerieName.getText().toString();
                    Intent intent = new Intent(context, SerieActivity.class);
                    intent.putExtra("serieName",str);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    break;



            }
        }


    }


}
