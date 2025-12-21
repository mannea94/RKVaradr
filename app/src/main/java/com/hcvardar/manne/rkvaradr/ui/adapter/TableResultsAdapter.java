package com.hcvardar.manne.rkvaradr.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.TableResult;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableResultsAdapter extends RecyclerView.Adapter<TableResultsAdapter.ViewHolder> {

    Context context;
    ArrayList<TableResult> superLeagues = new ArrayList<>();

    public void setItems(ArrayList<TableResult> superLeagues){
        this.superLeagues=superLeagues;
    }

    public TableResultsAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public TableResultsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_table_layout, parent, false);

        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(TableResultsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final TableResult superLiga = superLeagues.get(position);

            if(position == 0){
                hide(holder);
                holder.llRow.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.red)
                        );
            }else {
                holder.llRow.setBackgroundColor(
                        ContextCompat.getColor(context, R.color.light_black)
                );
                show(holder);
                holder.tvName.setText(superLiga.getName());
                holder.tvPlayedMatches.setText(String.valueOf(superLiga.getPlayedMatches()));
                holder.tvWonMatches.setText(String.valueOf(superLiga.getWonMatches()));
                holder.tvDrawMatches.setText(String.valueOf(superLiga.getDrawMatches()));
                holder.tvLostMatches.setText(String.valueOf(superLiga.getLostMatches()));
                holder.tvPoints.setText(String.valueOf(superLiga.getPoints()));
                Picasso.get().load(Constants.VARDAR_UPLOADS_URL.concat(superLiga.getLogo())).into(holder.ivLogo);
            }
    }

    @Override
    public int getItemCount() {
        return superLeagues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.llRow)
        LinearLayout llRow;
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.ivLogo)
        ImageView ivLogo;
        @BindView(R.id.tvPlayedMatches)
        TextView tvPlayedMatches;
        @BindView(R.id.tvWonMatches)
        TextView tvWonMatches;
        @BindView(R.id.tvDrawMatches)
        TextView tvDrawMatches;
        @BindView(R.id.tvLostMatches)
        TextView tvLostMatches;

        @BindView(R.id.tvPoints)
        TextView tvPoints;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void hide(TableResultsAdapter.ViewHolder holder){
        ViewUtils.toGone(holder.ivLogo);
        holder.tvName.setText("Екипа");
        holder.tvPlayedMatches.setText("Н");
        holder.tvWonMatches.setText("П");
        holder.tvDrawMatches.setText("Н");
        holder.tvLostMatches.setText("И");
        holder.tvPoints.setText("Б");
    }

    public void show(TableResultsAdapter.ViewHolder holder){
        ViewUtils.toVisible(holder.ivLogo);
    }
}
