package com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.interfaces.PhotoClickListener;
import com.hcvardar.manne.rkvaradr.ui.activity.gallery.video.YoutubeVideoActivity;
import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.GalleryAdapter;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.fragments.photo.GalleryPhotosFragment;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class GalleryActivity extends AppCompatActivity implements PhotoClickListener {

    @BindView(R.id.recyclerViewGallery)
    RecyclerView recyclerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;

    GalleryAdapter adapter2;

    boolean isVideo;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_gallery);
        ButterKnife.bind(this);

        isVideo = getIntent().getBooleanExtra("isVideo", false);

        adapter2 = new GalleryAdapter(this);
        adapter2.onPhotoClickListener(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
        getList();
        setActionBarInfo();
    }

    public void setActionBarInfo(){
        if(isVideo)
            tvName.setText(R.string.video_gallery);
        else
            tvName.setText(R.string.photo_gallery);
        ivBack.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
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
            intent.putExtra("extra_video", photoGallery);
            startActivity(intent);
        }else {
            GalleryPhotosFragment fragment = new GalleryPhotosFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("extra_gallery", photoGallery);
            fragment.setArguments(bundle);
            replaceFragment(fragment);
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
