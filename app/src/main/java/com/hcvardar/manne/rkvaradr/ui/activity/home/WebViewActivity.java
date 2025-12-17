package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.webView)
    WebView webView;
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.rlBackground)
    RelativeLayout rlBackground;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.loadUrl(checkUrl());
        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                //progressBar.setProgress(0);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                rlBackground.setVisibility(View.GONE);
                //progressBar.setProgress(100);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressBar.setVisibility(View.GONE);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

                progressBar.setProgress(progress); //Make the bar disappear after URL is loaded
                if (progress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
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
        }else if (getIntent().hasExtra(Constants.X_EXTRA)) {
            return getIntent().getStringExtra(Constants.X_EXTRA);
        }else if (getIntent().hasExtra(Constants.YOUTUBE_EXTRA)) {
            return getIntent().getStringExtra(Constants.YOUTUBE_EXTRA);
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
        }else if(getIntent().hasExtra("vesti")){
            return getIntent().getStringExtra("vesti");
        }else if(getIntent().hasExtra("results")){
            return getIntent().getStringExtra("results");
        }else if(getIntent().hasExtra("sostavi")){
            return getIntent().getStringExtra("sostavi");
        }else if(getIntent().hasExtra("contact")){
            return getIntent().getStringExtra("contact");
        }
        return "";
    }

}