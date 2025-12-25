package com.hcvardar.manne.rkvaradr.ui.adapter.team;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hcvardar.manne.rkvaradr.components.TopCropTransformation;
import com.hcvardar.manne.rkvaradr.ui.model.team.Player;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.Row_Click_Listener;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    Context context;
    ArrayList<Player> players = new ArrayList<>();
    Row_Click_Listener row_click_listener;

    public void setItems(ArrayList<Player> models){
        players = models;
    }

    public TeamAdapter(Context context1, Row_Click_Listener row_click_listener1){
        context=context1;
        row_click_listener=row_click_listener1;
    }

    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_ekipa, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final TeamAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final Player model = players.get(position);
            holder.playerName.setText(model.getIme());
            holder.playerNumber.setText(model.getBroj());
            holder.playerPos.setText(model.getPozicija());
            holder.player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_click_listener.onRowClick(model, position);
                }
            });


        Glide.with(context)
                .load(Constants.VARDAR_UPLOADS_URL.concat(model.getImageUrl()))
                .transform(new TopCropTransformation())
                .into(holder.player);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imagePlayer)
        ImageView player;
        @BindView(R.id.playerName)
        TextView playerName;
        @BindView(R.id.playerNumber)
        TextView playerNumber;
        @BindView(R.id.playerPos)
        TextView playerPos;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
