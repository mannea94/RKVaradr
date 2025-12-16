package com.hcvardar.manne.rkvaradr.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.model.Sponsor;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.SponsorClickListener;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ViewHolder> {

    Context context;
    ArrayList<Sponsor> sponsors = new ArrayList<>();
    SponsorClickListener sponsorClickListener;

    public void setItems(ArrayList<Sponsor> sponsor){
        sponsors=sponsor;
    }

    public void onSponsorClickListener(SponsorClickListener listener){
        this.sponsorClickListener = listener;
    }

    public SponsorsAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public SponsorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_sponsors_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SponsorsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final Sponsor sponsor = sponsors.get(position);

        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(sponsor.getImageUrl()))
                .into(holder.imgSponsor);

        holder.imgSponsor.setOnClickListener(view -> {
            sponsorClickListener.onSponsorClick(sponsor);
        });
    }

    @Override
    public int getItemCount() {
        return sponsors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgSponsor)
        ImageView imgSponsor;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
