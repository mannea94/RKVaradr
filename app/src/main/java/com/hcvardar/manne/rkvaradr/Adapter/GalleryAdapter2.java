package com.hcvardar.manne.rkvaradr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.Model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.Row_Click_Listener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class GalleryAdapter2 extends RecyclerView.Adapter<GalleryAdapter2.ViewHolder> {

    Context context;
    ArrayList<EkipaModel> ekipaModels = new ArrayList<>();
    Row_Click_Listener row_click_listener;

    public void setItems(ArrayList<EkipaModel> models){
        ekipaModels=models;
    }

    public GalleryAdapter2(Context context1, Row_Click_Listener row_click_listener1){
        context=context1;
        row_click_listener=row_click_listener1;
    }

    @Override
    public GalleryAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_gallery, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GalleryAdapter2.ViewHolder holder, final int position) {
            final EkipaModel model = ekipaModels.get(position);
            holder.vardarChampions.setText(model.getIme());

            holder.precekSkopje.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_click_listener.onRowClick(model, position);
                }
            });


        Picasso.get()
                .load(model.getImageUrl())
                .fit()
                .into(holder.precekSkopje);

//            holder.player.setImageResource(R.drawable.dainis_krishtopans);
//
//
//            holder.player.setImageResource(R.drawable.igor_karachikj);
//
//
//            holder.player.setImageResource(R.drawable.stojanche_stoilov);
//
//
//            holder.player.setImageResource(R.drawable.stash_skube);

    }

    @Override
    public int getItemCount() {
        return ekipaModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.precekSkopje)
        ImageView precekSkopje;
        @BindView(R.id.textGallery)
        TextView vardarChampions;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
