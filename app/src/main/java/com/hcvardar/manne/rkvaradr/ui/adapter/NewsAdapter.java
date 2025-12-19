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

import com.bumptech.glide.Glide;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.ClubInfo;
import com.hcvardar.manne.rkvaradr.ui.model.News;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<News> newsList = new ArrayList<>();

    public void setItems(ArrayList<News> newsList){
        this.newsList=newsList;
    }

    public NewsAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_news_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final News news = newsList.get(position);

        holder.tvTitle.setText(news.getTitle());

        holder.ivHeader.getLayoutParams().height = (int) (ViewUtils.getHeight(context) * 0.35);

        Glide.with(context).load(Constants.VARDAR_UPLOADS_URL.concat(news.getHeaderImage()))
                .centerCrop()
                .into(holder.ivHeader);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivHeader)
        ImageView ivHeader;
        @BindView(R.id.tvTitle)
        TextView tvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
