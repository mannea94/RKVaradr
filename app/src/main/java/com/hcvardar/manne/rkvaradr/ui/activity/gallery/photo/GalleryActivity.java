package com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.interfaces.PhotoClickListener;
import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.GalleryAdapter;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity implements PhotoClickListener {


    @BindView(R.id.recyclerViewGallery)
    RecyclerView recyclerView;

    GalleryAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);


        adapter2 = new GalleryAdapter(this);
        adapter2.onPhotoClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
        getList();
        adapter2.notifyDataSetChanged();
    }

    public void getList(){
        adapter2.setItems(new GlobalClass().getListPhotoGallery(this, 4));
    }

    @Override
    public void onPhotoClick(PhotoGallery photoGallery, int position) {
        Intent intent = new Intent(GalleryActivity.this, GalleryPhotosActivity.class);
        intent.putExtra("extra_gallery",photoGallery);
        intent.putExtra("pos_gallery",position);
        startActivity(intent);
    }
}
