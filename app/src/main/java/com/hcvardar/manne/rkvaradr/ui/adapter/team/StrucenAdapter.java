package com.hcvardar.manne.rkvaradr.ui.adapter.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.model.Player;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class StrucenAdapter extends RecyclerView.Adapter<StrucenAdapter.ViewHolder> {

    Context context;
    ArrayList<Player> players = new ArrayList<>();


    public void setItems(ArrayList<Player> models){
        players =models;
    }

    public StrucenAdapter(Context context1){
        context=context1;

    }

    @Override
    public StrucenAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_strucen, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StrucenAdapter.ViewHolder holder, final int position) {
            final Player model = players.get(position);
            holder.strucenName.setText(model.getIme());
            holder.strucenPos.setText(model.getPozicija());



        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(model.getImageUrl()))
                .into(holder.imageStab);
    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageStab)
        ImageView imageStab;
        @BindView(R.id.strucenName)
        TextView strucenName;
        @BindView(R.id.strucenPozicija)
        TextView strucenPos;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
