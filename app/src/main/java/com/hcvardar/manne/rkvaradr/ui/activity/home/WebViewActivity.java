package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;

import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.webView)
    WebView webView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;



    @SuppressLint({"SetJavaScriptEnabled", "SourceLockedOrientationActivity"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webView.getSettings().setSafeBrowsingEnabled(true);
        }

        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri uri = request.getUrl();
                return handleUri(uri);
            }

            // For Android < Lollipop
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return handleUri(Uri.parse(url));
            }

            private boolean handleUri(Uri uri) {
                String scheme = uri.getScheme();

                // HTTP & HTTPS → load inside WebView
                assert scheme != null;
                if (scheme.equals("http") || scheme.equals("https")) {
                    return false;
                }

                // we handled it
                if (uri.toString().startsWith("intent://")) {
                    try {
                        Intent intent = Intent.parseUri(uri.toString(), Intent.URI_INTENT_SCHEME);
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    // Handle common external schemes
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    try {
                        webView.getContext().startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        // App not installed
                    }

                }
                return true;
            }

        });

        webView.loadUrl(checkUrl());

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                progressBar.setProgress(progress); //Make the bar disappear after URL is loaded
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        setActionBarInfo();

    }

    public void setActionBarInfo(){
        ViewUtils.showStatusBar(this);
        tvName.setText(GlobalClass.checkWebviewTitle(getIntent()));
        ivBack.setOnClickListener(view -> {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    public String checkUrl() {
        if (getIntent().hasExtra(Constants.VARDAR_SHOP_EXTRA)) {
            return getIntent().getStringExtra(Constants.VARDAR_SHOP_EXTRA);
        } else if (getIntent().hasExtra(Constants.VARDAR_OFFICIAL_EXTRA)) {
            return getIntent().getStringExtra(Constants.VARDAR_OFFICIAL_EXTRA);
        } else if (getIntent().hasExtra(Constants.FACEBOOK_EXTRA)) {
            return getIntent().getStringExtra(Constants.FACEBOOK_EXTRA);
        }else if (getIntent().hasExtra(Constants.INSTAGRAM_EXTRA)) {
            return getIntent().getStringExtra(Constants.INSTAGRAM_EXTRA);
        }else if (getIntent().hasExtra(Constants.YOUTUBE_EXTRA)) {
            return getIntent().getStringExtra(Constants.YOUTUBE_EXTRA);
        }else if (getIntent().hasExtra(Constants.TICKETS_MK_EXTRA)) {
            return getIntent().getStringExtra(Constants.TICKETS_MK_EXTRA);
        }else if (getIntent().hasExtra(Constants.VIBER)) {
            return getIntent().getStringExtra(Constants.VIBER);
        }else if (getIntent().hasExtra(Constants.VARDAR_CONTACT_EXTRA)) {
            return getIntent().getStringExtra(Constants.VARDAR_CONTACT_EXTRA);
        }else if (getIntent().hasExtra(Constants.TICKETS_PLUS_EXTRA)) {
            return getIntent().getStringExtra(Constants.TICKETS_PLUS_EXTRA);
        }else if (getIntent().hasExtra(Constants.LEAGUE_EHF_EXTRA)) {
            return getIntent().getStringExtra(Constants.LEAGUE_EHF_EXTRA);
        }else if (getIntent().hasExtra(Constants.LEAGUE_EHF_PLUS_EXTRA)) {
            return getIntent().getStringExtra(Constants.LEAGUE_EHF_PLUS_EXTRA);
        }else if (getIntent().hasExtra(Constants.LEAGUE_EHF_TV_EXTRA)) {
            return getIntent().getStringExtra(Constants.LEAGUE_EHF_TV_EXTRA);
        }else if(getIntent().hasExtra(Constants.SPONSOR_EXTRA)){
            return getIntent().getStringExtra(Constants.SPONSOR_EXTRA);
        }else if(getIntent().hasExtra("results")){
            return getIntent().getStringExtra("results");
        }else if(getIntent().hasExtra("sostavi")){
            return getIntent().getStringExtra("sostavi");
        }
        return "";
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    protected void onDestroy() {
        webView.destroy();
        super.onDestroy();
    }

}