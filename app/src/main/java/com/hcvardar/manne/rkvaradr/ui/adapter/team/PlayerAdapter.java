package com.hcvardar.manne.rkvaradr.ui.adapter.team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.Row_Click_Listener;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    Context context;
    ArrayList<EkipaModel> ekipaModels = new ArrayList<>();
    Row_Click_Listener row_click_listener;

    public void setItems(ArrayList<EkipaModel> models){
        ekipaModels=models;
    }

    public PlayerAdapter(Context context1, Row_Click_Listener row_click_listener1){
        context=context1;
        row_click_listener=row_click_listener1;
    }

    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_igraci, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PlayerAdapter.ViewHolder holder, final int position) {
            final EkipaModel model = ekipaModels.get(position);
            holder.playerName.setText(model.getIme());
            holder.player.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_click_listener.onRowClick(model, position);
                }
            });
        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(model.getImageUrl2()))
                .fit()
                .into(holder.player);


    }

    @Override
    public int getItemCount() {
        return ekipaModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imagePlayer)
        ImageView player;
        @BindView(R.id.imeIgrac)
        TextView playerName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
