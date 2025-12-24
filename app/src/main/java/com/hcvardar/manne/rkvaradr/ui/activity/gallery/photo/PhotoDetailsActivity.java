package com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo;



import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.hcvardar.manne.rkvaradr.components.DepthPageTransformer;
import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.SectionsPagerAdapter;
import com.hcvardar.manne.rkvaradr.ui.model.ImageModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.ImageDownload;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class PhotoDetailsActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE = 1001;
    SectionsPagerAdapter mSectionsPagerAdapter;
    ArrayList<ImageModel> data;
    int pos;
    String imageUrl="";

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivClose)
    ImageView ivClose;
    @BindView(R.id.ivDownload)
    ImageView ivDownload;
    @BindView(R.id.ivShare)
    ImageView ivShare;
    @BindView(R.id.view_pager)
    ViewPager2 mViewPager;

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        data = new ArrayList<>();
        data = getIntent().getParcelableArrayListExtra("data");
        pos = getIntent().getIntExtra("pos", 0);

        tvName.setText(data.get(pos).getName());
        imageUrl = data.get(pos).getUrl();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(this, data);

        // Set up the ViewPager with the sections adapter.

        mViewPager.setPageTransformer(new DepthPageTransformer());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(pos);
        registerOnPageChangeCallback();

        ivClose.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());

        ivDownload.setOnClickListener(view -> saveImageWithPermissionCheck());

        ivShare.setOnClickListener(view -> ImageDownload.downloadAndShareImage(this, imageUrl));

    }

    public void registerOnPageChangeCallback(){
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvName.setText(data.get(position).getName());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }


    private void saveImageWithPermissionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Android 10+ → no permission needed
            ImageDownload.downloadImage(this, imageUrl, Build.VERSION.SDK_INT);
        } else {
            if (hasStoragePermission()) {
                ImageDownload.downloadImage(this, imageUrl, Build.VERSION.SDK_INT);
            } else {
                requestStoragePermission();
            }
        }
    }

    private boolean hasStoragePermission() {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestStoragePermission() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                STORAGE_PERMISSION_CODE
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults, int deviceId) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults, deviceId);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // ✅ Permission granted → continue saving image
                ImageDownload.downloadImage(this, imageUrl, Build.VERSION.SDK_INT);
            } else {
                // ❌ Permission denied
                Toast.makeText(this,
                        "Storage permission is required to save images",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

}
