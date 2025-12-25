package com.hcvardar.manne.rkvaradr.ui.adapter.club;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.club.ClubInfo;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class ClubInfoAdapter extends RecyclerView.Adapter<ClubInfoAdapter.ViewHolder> {

    Context context;
    ArrayList<ClubInfo> clubInfos = new ArrayList<>();

    public void setItems(ArrayList<ClubInfo> clubInfos){
        this.clubInfos=clubInfos;
    }

    public ClubInfoAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public ClubInfoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_club_info_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClubInfoAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final ClubInfo clubInfo = clubInfos.get(position);

        holder.tvParagraph.setText(clubInfo.getParagraph());

        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(clubInfo.getImageUrl()))
                .into(holder.ivParagraph);

    }

    @Override
    public int getItemCount() {
        return clubInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivParagraph)
        ImageView ivParagraph;
        @BindView(R.id.tvParagraph)
        TextView tvParagraph;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
