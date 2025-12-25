package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.annotation.SuppressLint;
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

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.NewsClickListener;
import com.hcvardar.manne.rkvaradr.ui.adapter.home.NewsAdapter;
import com.hcvardar.manne.rkvaradr.ui.fragments.news.CurrentNewsFragment;
import com.hcvardar.manne.rkvaradr.ui.model.news.News;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
public class NewsActivity extends AppCompatActivity implements NewsClickListener {

    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.ivBack)
    ImageView ivBack;

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    NewsAdapter adapter;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        setActionBarInfo();

        adapter = new NewsAdapter(this);
        adapter.onNewsClickListener(this);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getListNews(this, 10));
    }

    public void setActionBarInfo(){
        tvName.setText(R.string.news);
        ivBack.setOnClickListener(view -> getOnBackPressedDispatcher().onBackPressed());
    }

    @Override
    public void onNewsClick(News news) {
        CurrentNewsFragment fragment = new CurrentNewsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("current_news", news);
        fragment.setArguments(bundle);
        replaceFragment(fragment);
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