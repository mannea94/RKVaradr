package com.hcvardar.manne.rkvaradr.ui.adapter.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.interfaces.PhotoClickListener;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.gallery.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by manne on 03.7.2019.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    Context context;
    ArrayList<PhotoGallery> photoGalleries = new ArrayList<>();
    PhotoClickListener photoClickListener;

    public void setItems(ArrayList<PhotoGallery> photoGalleries){
        this.photoGalleries=photoGalleries;
    }

    public void onPhotoClickListener(PhotoClickListener listener){
        this.photoClickListener = listener;
    }

    public GalleryAdapter(Context context1){
        context=context1;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_gallery, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
            final PhotoGallery photoGallery = photoGalleries.get(position);
            holder.vardarChampions.setText(photoGallery.getNameEvent());

            holder.precekSkopje.setOnClickListener(v -> photoClickListener.onPhotoClick(photoGallery, position));

        holder.precekSkopje.getLayoutParams().height = (int) (ViewUtils.getHeight(context) * 0.3);
        holder.view.getLayoutParams().height = (int) (ViewUtils.getHeight(context) * 0.3/2);

        Picasso.get()
                .load(Constants.VARDAR_UPLOADS_URL.concat(photoGallery.getHeaderImageUrl()))
                .fit()
                .centerCrop()
                .into(holder.precekSkopje);

    }

    @Override
    public int getItemCount() {
        return photoGalleries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.precekSkopje)
        ImageView precekSkopje;
        @BindView(R.id.textGallery)
        TextView vardarChampions;
        @BindView(R.id.view)
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
