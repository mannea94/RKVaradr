package com.hcvardar.manne.rkvaradr.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.model.Result;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ViewHolder> {

    Context context;
    ArrayList<Result> results = new ArrayList<>();

    public void setItems(ArrayList<Result> result){
        results=result;
    }

    public ResultsAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public ResultsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_result_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ResultsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final Result result = results.get(position);

        holder.tvHostName.setText(result.getHostName());
        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(result.getHostLogo()))
                .into(holder.ivHostLogo);

        holder.tvGuestName.setText(result.getGuestName());
        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(result.getGuestLogo()))
                .into(holder.ivGuestLogo);

        String resultMatch = result.getHostResult() + ":" + result.getGuestResult();
        holder.tvResult.setText(resultMatch);

        holder.tvDate.setText(result.getDate());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvHostName)
        TextView tvHostName;
        @BindView(R.id.ivHostLogo)
        ImageView ivHostLogo;
        @BindView(R.id.tvGuestName)
        TextView tvGuestName;
        @BindView(R.id.ivGuestLogo)
        ImageView ivGuestLogo;
        @BindView(R.id.tvResult)
        TextView tvResult;
        @BindView(R.id.tvDate)
        TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
