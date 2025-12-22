package com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.interfaces.PhotoClickListener;
import com.hcvardar.manne.rkvaradr.ui.activity.gallery.video.YoutubeVideoActivity;
import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.GalleryAdapter;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity implements PhotoClickListener {


    @BindView(R.id.recyclerViewGallery)
    RecyclerView recyclerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;

    GalleryAdapter adapter2;

    boolean isVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        setActionBarInfo();

        isVideo = getIntent().getBooleanExtra("isVideo", false);

        adapter2 = new GalleryAdapter(this);
        adapter2.onPhotoClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
        getList();
        adapter2.notifyDataSetChanged();
    }

    public void setActionBarInfo(){
        if(isVideo)
            tvName.setText(R.string.video_gallery);
        else
            tvName.setText(R.string.photo_gallery);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }

    public void getList(){
        if(isVideo)
            adapter2.setItems(new GlobalClass().getListPhotoGallery(this, 11));
        else
            adapter2.setItems(new GlobalClass().getListPhotoGallery(this, 4));
    }

    @Override
    public void onPhotoClick(PhotoGallery photoGallery, int position) {
        if(photoGallery.isVideo()){
            Intent intent = new Intent(GalleryActivity.this, YoutubeVideoActivity.class);
            intent.putExtra("extra_gallery", photoGallery);
            startActivity(intent);
        }else {
            Intent intent = new Intent(GalleryActivity.this, GalleryPhotosActivity.class);
            intent.putExtra("extra_gallery",photoGallery);
            intent.putExtra("pos_gallery",position);
            startActivity(intent);
        }
    }
}
