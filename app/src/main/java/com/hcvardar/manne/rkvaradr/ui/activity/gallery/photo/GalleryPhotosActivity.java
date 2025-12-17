package com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.GalleryPhotoAdapter;
import com.hcvardar.manne.rkvaradr.ui.model.ImageModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.RecyclerItemClickListener;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import java.util.ArrayList;

public class GalleryPhotosActivity extends AppCompatActivity {

    GalleryPhotoAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<ImageModel> data = new ArrayList<>();

    PhotoGallery photoGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery_photos);
        Intent intent = getIntent();

        photoGallery = new PhotoGallery();
        photoGallery = (PhotoGallery) intent.getSerializableExtra("extra_gallery");

        if(intent.hasExtra("extra_gallery")) {
            for(int i=0; i< photoGallery.getImages().size(); i++){
                ImageModel imageModel = new ImageModel();
                int j = i+1;
                imageModel.setName("Слика " + j + " / " + photoGallery.getImages().size());
                imageModel.setUrl(Constants.VARDAR_UPLOADS_URL.concat(photoGallery.getImages().get(i)));
                data.add(imageModel);
            }
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true);


        mAdapter = new GalleryPhotoAdapter(GalleryPhotosActivity.this, data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                (view, position) -> {
                    Intent intent1 = new Intent(GalleryPhotosActivity.this, PhotoDetailsActivity.class);
                    intent1.putParcelableArrayListExtra("data", data);
                    intent1.putExtra("pos", position);
                    startActivity(intent1);

                }));
    }
}
