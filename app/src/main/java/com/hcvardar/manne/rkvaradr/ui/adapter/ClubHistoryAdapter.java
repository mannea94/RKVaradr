package com.hcvardar.manne.rkvaradr.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.ClubInfo;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class ClubHistoryAdapter extends RecyclerView.Adapter<ClubHistoryAdapter.ViewHolder> {

    Context context;
    ArrayList<ClubInfo> clubInfos = new ArrayList<>();

    public void setItems(ArrayList<ClubInfo> clubInfos){
        this.clubInfos=clubInfos;
    }

    public ClubHistoryAdapter(Context c){
        context=c;
    }

    @NonNull
    @Override
    public ClubHistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_club_history_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClubHistoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final ClubInfo clubInfo = clubInfos.get(position);

        holder.tvTitle.setText(clubInfo.getTitle());
        holder.tvParagraph.setText(clubInfo.getParagraph());
        holder.tvYear.setText(clubInfo.getYear());


//        holder.rlItem.getViewTreeObserver()
//                .addOnGlobalLayoutListener(() -> holder.view.getLayoutParams().height = holder.rlItem.getHeight());

        holder.rlItem.measure(View.MeasureSpec.makeMeasureSpec(holder.rlItem.getHeight(),
                View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.UNSPECIFIED);
        holder.view.getLayoutParams().height = holder.rlItem.getMeasuredHeight();

//        holder.rlItem.post(() -> {
//                holder.itemView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
//                holder.view.getLayoutParams().height = holder.rlItem.getMeasuredHeight();
//        });
    }

    @Override
    public int getItemCount() {
        return clubInfos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rlItem)
        RelativeLayout rlItem;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.tvTitle)
        TextView tvTitle;
        @BindView(R.id.tvParagraph)
        TextView tvParagraph;
        @BindView(R.id.tvYear)
        TextView tvYear;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
