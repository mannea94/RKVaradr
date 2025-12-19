package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.adapter.NewsAdapter;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import org.checkerframework.checker.units.qual.N;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        tvName.setText(R.string.news);

        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });

        adapter = new NewsAdapter(this);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getListNews(this, 10));

    }
}