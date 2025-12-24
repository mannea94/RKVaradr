package com.hcvardar.manne.rkvaradr.ui.activity.gallery.video;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.FullscreenListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options.IFramePlayerOptions;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


import butterknife.BindView;
import butterknife.ButterKnife;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class YoutubeVideoActivity extends AppCompatActivity implements
    FullscreenListener {

    @BindView(R.id.youtube_player_view)
    YouTubePlayerView youTubePlayerView;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    @BindView(R.id.rlActionBar)
    RelativeLayout rlActionBar;

    PhotoGallery photoGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_youtube_video);
        ButterKnife.bind(this);

        photoGallery = (PhotoGallery) getIntent().getSerializableExtra("extra_video");

        // VERY IMPORTANT (prevents memory leaks)
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.setEnableAutomaticInitialization(false);
        youTubePlayerView.addFullscreenListener(this);

        IFramePlayerOptions iFramePlayerOptions = new IFramePlayerOptions.Builder(this)
                .controls(1)
                // enable full screen button
                .fullscreen(1)
                .build();

        YouTubePlayerListener listener = new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(photoGallery.getVideoId(), 0);
            }
        };

        youTubePlayerView.initialize(listener, iFramePlayerOptions);
        setActionBarInfo();
    }

    public void setActionBarInfo(){
        tvName.setText(photoGallery.getNameEvent());
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Landscape mode
            ViewUtils.toGone(rlActionBar);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Portrait mode
            ViewUtils.toVisible(rlActionBar);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }

    @Override
    public void onEnterFullscreen(@NonNull View view, @NonNull Function0<Unit> function0) {
        enterFullscreen(view);
    }

    @Override
    public void onExitFullscreen() {
        exitFullscreen();
    }

    private void enterFullscreen(View fullscreenView) {
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        decorView.addView(fullscreenView,
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        youTubePlayerView.setVisibility(View.GONE);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void exitFullscreen() {
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        decorView.removeViewAt(decorView.getChildCount() - 1);

        youTubePlayerView.setVisibility(View.VISIBLE);

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}