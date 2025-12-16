package com.hcvardar.manne.rkvaradr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.google.android.material.navigation.NavigationView;
import com.hcvardar.manne.rkvaradr.ui.adapter.MyPageAdapter2;
import com.hcvardar.manne.rkvaradr.ui.adapter.PlayerAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.ResultsAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.SponsorsAdapter;
import com.hcvardar.manne.rkvaradr.CheckConnection;
import com.hcvardar.manne.rkvaradr.ui.fragments.Fragment10;
import com.hcvardar.manne.rkvaradr.ui.fragments.Fragment11;
import com.hcvardar.manne.rkvaradr.ui.fragments.Fragment12;
import com.hcvardar.manne.rkvaradr.ui.fragments.Fragment13;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaData;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.ui.model.InternetConnection;
import com.hcvardar.manne.rkvaradr.ui.model.Result;
import com.hcvardar.manne.rkvaradr.ui.model.Sponsor;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.components.CirclePagerIndicatorDecoration;
import com.hcvardar.manne.rkvaradr.interfaces.Row_Click_Listener;
import com.hcvardar.manne.rkvaradr.interfaces.SponsorClickListener;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SponsorClickListener {

    String [] activity_titles;
    @BindView(R.id.imageHeder)
    ImageView imageView;
    @BindView(R.id.imageMoto)
    ImageView imageMoto;

    @BindView(R.id.recyclerViewPlayers)
    RecyclerView recyclerView;
    PlayerAdapter adapter;
    EkipaData data;
    EkipaModel model;
    @BindView(R.id.vardarLogo)
    ImageView logo;

    @BindView(R.id.onlineStore)
    ImageView onlineStore;

    @BindView(R.id.facebook)
    ImageView facebook;
    @BindView(R.id.twitter)
    ImageView twitter;
    @BindView(R.id.mail)
    ImageView mail;
    @BindView(R.id.youtube)
    ImageView youtube;
    @BindView(R.id.tickets)
    ImageView tickets;

    @BindView(R.id.viewPager2)
    ViewPager viewPager2;
    @BindView(R.id.SliderDots2)
    LinearLayout sliderDotspanel2;
    private int dotscount2;
    private ImageView[] dots2;
    MyPageAdapter2 viewPagerAdapter2;
    SponsorsAdapter sponsorsAdapter;
    ArrayList<Sponsor> sponsors;

    @BindView(R.id.rvSponsors)
    RecyclerView rvSponsors;

    @BindView(R.id.rvResults)
    RecyclerView rvResults;

    ArrayList<Result> results;
    ResultsAdapter resultsAdapter;

    @BindView(R.id.league1)
    ImageView league1;
    @BindView(R.id.league2)
    ImageView league2;
    @BindView(R.id.league3)
    ImageView league3;

    @BindView(R.id.imgCover)
    ImageView imgCover;


    InternetConnection internetConnection;
    CheckConnection checkConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPagerAdapter2 =  new MyPageAdapter2(this.getSupportFragmentManager());
        viewPagerAdapter2.addFragment(new Fragment10());
        viewPagerAdapter2.addFragment(new Fragment11());
        viewPagerAdapter2.addFragment(new Fragment12());
        viewPagerAdapter2.addFragment(new Fragment13());
        viewPager2.setAdapter(viewPagerAdapter2);
        setUpViewDots2();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        internetConnection=new InternetConnection();
        activity_titles=getResources().getStringArray(R.array.string_array);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawableImageViewTarget divt = new DrawableImageViewTarget(tickets);
        Glide.with(this).load(R.drawable.za_klubot).into(divt.getView());

        imageMoto.setImageResource(R.drawable.eden_zivot);

        model=new EkipaModel();
        data=new EkipaData();

        adapter = new PlayerAdapter(this, new Row_Click_Listener() {
            @Override
            public void onRowClick(EkipaModel model, int position) {
                Intent intent = new Intent(MainActivity.this, IgracActivity.class);
                intent.putExtra("EXTRA_2", model);
                intent.putExtra("POS", position);
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        recyclerView.setAdapter(adapter);
        adapter.setItems(new GlobalClass().getList(this, 0));
        adapter.notifyDataSetChanged();

        sponsorsAdapter = new SponsorsAdapter(this);
        sponsorsAdapter.onSponsorClickListener(this);
        sponsorsAdapter.setItems(new GlobalClass().getListSponsors(this, 2));
        rvSponsors.setHasFixedSize(true);
        rvSponsors.setLayoutManager(new GridLayoutManager(this, 4));
        rvSponsors.setAdapter(sponsorsAdapter);

        resultsAdapter = new ResultsAdapter(this);
        SnapHelper snapHelper = new PagerSnapHelper();
        resultsAdapter.setItems(new GlobalClass().getListResults(this, 3));
        rvResults.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
        rvResults.setAdapter(resultsAdapter);
        snapHelper.attachToRecyclerView(rvResults);
        rvResults.addItemDecoration(new CirclePagerIndicatorDecoration());

        getListeners();
        loadPhotos();

    }

    public void setUpViewDots2(){
        dotscount2 = viewPagerAdapter2.getCount();
        dots2 = new ImageView[dotscount2];

        for(int i = 0; i < dotscount2; i++){

            dots2[i] = new ImageView(this);
            dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel2.addView(dots2[i], params);

        }

        dots2[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount2; i++){
                    dots2[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots2[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_zaklubot) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, KlubActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_ekipa) {
            Intent intent = new Intent(MainActivity.this, EkipaActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_galerija) {
            Intent intent = new Intent(MainActivity.this, GalleryActivity2.class);
            startActivity(intent);

        }

        else if (id == R.id.nav_strucen) {
        Intent intent = new Intent(MainActivity.this, StrucenstabActivity.class);
        startActivity(intent);
        }
        else if (id == R.id.nav_rakovodstvo) {
            Intent intent = new Intent(MainActivity.this, RakovodtsvoActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getListeners(){

        imageView.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, KlubActivity.class));
        });

        //WEBVIEW
        onlineStore.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.VARDAR_SHOP_EXTRA, Constants.VARDAR_FAN_SHOP_URL);
            startActivity(i);
        });
        logo.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.VARDAR_OFFICIAL_EXTRA, Constants.BASE_VARDAR_URL);
            startActivity(i);
        });

        facebook.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.FACEBOOK_EXTRA, Constants.FACEBOOK_URL);
            startActivity(i);
        });
        twitter.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.X_EXTRA, Constants.X_URL);
            startActivity(i);
        });
        mail.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.VARDAR_CONTACT_EXTRA, Constants.VARDAR_CONTACT_URL);
            startActivity(i);
        });
        youtube.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.YOUTUBE_EXTRA, Constants.YOUTUBE_URL);
            startActivity(i);
        });

        tickets.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.TICKETS_PLUS_EXTRA, Constants.TICKETS_PLUS_URL);
            startActivity(i);
        });

        league1.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.LEAGUE_EHF_EXTRA, Constants.LEAGUE_EHF_URL);
            startActivity(i);
        });

        league2.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.LEAGUE_EHF_PLUS_EXTRA, Constants.LEAGUE_EHF_PLUS_URL);
            startActivity(i);
        });

        league3.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.LEAGUE_EHF_TV_EXTRA, Constants.LEAGUE_EHF_TV_URL);
            startActivity(i);
        });
    }

    public void loadPhotos(){
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/08/Vardar-tim-scaled.jpg")
                .fit()
                .into(imgCover);

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/06/pehari_web_naslovna5.jpg")
                .fit()
                .into(imageView);


        Picasso.get()
                .load("https://vardarfanshop.com/image/catalog/Baneri/Baner_novdres2526B.jpg")
//                .fit()
                .into(onlineStore);

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/09/300x100px-1-300x100.png")
                .fit()
                .into(league1);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/09/300x100px-300x100.png")
                .fit()
                .into(league2);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/09/EHF_TV_202425_Web_300x100px-copy.jpg")
                .fit()
                .into(league3);
    }

    @Override
    public void onSponsorClick(Sponsor sponsor) {
        Intent i = new Intent(this, WebViewActivity.class);
        if(sponsor.getWebLink()!=null && !sponsor.getWebLink().isEmpty()){
            i.putExtra(Constants.SPONSOR_EXTRA, sponsor.getWebLink());
            startActivity(i);
        }
    }
}
