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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.NewsClickListener;
import com.hcvardar.manne.rkvaradr.ui.adapter.NewsAdapter;
import com.hcvardar.manne.rkvaradr.ui.fragments.CurrentNewsFragment;
import com.hcvardar.manne.rkvaradr.ui.model.News;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsActivity extends AppCompatActivity implements NewsClickListener {

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

        setActionBarInfo();

        adapter = new NewsAdapter(this);
        adapter.onNewsClickListener(this);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvNews.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getListNews(this, 10));
    }

    public void setActionBarInfo(){
        ViewUtils.showStatusBar(this);
        tvName.setText(R.string.news);
        ivBack.setOnClickListener(view -> {
            getOnBackPressedDispatcher().onBackPressed();
        });
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