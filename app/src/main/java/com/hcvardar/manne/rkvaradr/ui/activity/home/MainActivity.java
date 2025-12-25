package com.hcvardar.manne.rkvaradr.ui.activity.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.hcvardar.manne.rkvaradr.MainViewModel;
import com.hcvardar.manne.rkvaradr.MainViewModelFactory;
import com.hcvardar.manne.rkvaradr.NetworkMonitor;
import com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo.GalleryActivity;
import com.hcvardar.manne.rkvaradr.ui.activity.team.TeamActivity;
import com.hcvardar.manne.rkvaradr.ui.activity.team.RakovodtsvoActivity;
import com.hcvardar.manne.rkvaradr.ui.activity.team.StrucenstabActivity;
import com.hcvardar.manne.rkvaradr.ui.adapter.FragmentAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.team.PlayerAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.home.ResultsAdapter;
import com.hcvardar.manne.rkvaradr.ui.adapter.home.SponsorsAdapter;
import com.hcvardar.manne.rkvaradr.ui.fragments.results.EuropeanLeagueFragment;
import com.hcvardar.manne.rkvaradr.ui.fragments.results.SuperLigaFragment;
import com.hcvardar.manne.rkvaradr.ui.fragments.results.PlayOffFragment;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.Player;
import com.hcvardar.manne.rkvaradr.ui.model.Sponsor;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.components.CirclePagerIndicatorDecoration;
import com.hcvardar.manne.rkvaradr.interfaces.SponsorClickListener;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

@SuppressLint("NonConstantResourceId")
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
    Player model;
    @BindView(R.id.vardarLogo)
    ImageView logo;

    @BindView(R.id.onlineStore)
    ImageView onlineStore;

    @BindView(R.id.facebook)
    ImageView facebook;
    @BindView(R.id.fun_shop)
    ImageView fun_shop;
    @BindView(R.id.instagram)
    ImageView instagram;
    @BindView(R.id.youtube)
    ImageView youtube;

    @BindView(R.id.ticket)
    ImageView ticket;

    @BindView(R.id.viber)
    ImageView viber;

    @BindView(R.id.tickets)
    ImageView tickets;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    FragmentAdapter fragmentAdapter;
    @BindView(R.id.viewPager)
    ViewPager2 viewPager;
    SponsorsAdapter sponsorsAdapter;

    @BindView(R.id.rvSponsors)
    RecyclerView rvSponsors;

    @BindView(R.id.rvResults)
    RecyclerView rvResults;
    ResultsAdapter resultsAdapter;

    @BindView(R.id.league1)
    ImageView league1;
    @BindView(R.id.league2)
    ImageView league2;
    @BindView(R.id.league3)
    ImageView league3;

    @BindView(R.id.imgCover)
    ImageView imgCover;


    @SuppressLint({"SourceLockedOrientationActivity", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentAdapter = new FragmentAdapter(this);
        fragmentAdapter.addFragment(new SuperLigaFragment(), getString(R.string.super_league_2025_26));
        fragmentAdapter.addFragment(new PlayOffFragment(), getString(R.string.play_off_2024_25));
        fragmentAdapter.addFragment(new EuropeanLeagueFragment(), getString(R.string.european_league_2025_26));
        viewPager.setAdapter(fragmentAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(fragmentAdapter.getTitle(position))
        ).attach();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        activity_titles=getResources().getStringArray(R.array.string_array);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        DrawableImageViewTarget divt = new DrawableImageViewTarget(tickets);
        Glide.with(this).load(R.drawable.tickets_mk).into(divt.getView());

        imageMoto.setImageResource(R.drawable.eden_zivot);

        model=new Player();

        adapter = new PlayerAdapter(this, (model, position) -> {
            Intent intent = new Intent(MainActivity.this, TeamActivity.class);
            intent.putExtra("player_info", model);
            startActivity(intent);
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
        handleOnBackPressed();
        //checkInternet();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_zaklubot) {
            Intent intent = new Intent(MainActivity.this, KlubActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_ekipa) {
            Intent intent = new Intent(MainActivity.this, TeamActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery_photo) {
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            intent.putExtra("isVideo", false);
            startActivity(intent);
        } else if (id == R.id.nav_gallery_video) {
            Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
            intent.putExtra("isVideo", true);
            startActivity(intent);
        } else if(id == R.id.nav_vesti){
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            intent.putExtra("vesti", "https://rkvardar.com.mk/vesti/");
            startActivity(intent);
        } else if(id == R.id.nav_results){
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("results", "https://rkvardar.com.mk/rezultati/");
            startActivity(intent);
        } else if(id == R.id.nav_poranesni_sostavi){
            Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
            intent.putExtra("sostavi", "https://rkvardar.com.mk/sostavi/");
            startActivity(intent);
        } else if(id == R.id.nav_contact){
            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getListeners(){

        imageView.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, KlubActivity.class)));

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
        fun_shop.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.VARDAR_SHOP_EXTRA, Constants.VARDAR_FAN_SHOP_URL);
            startActivity(i);
        });
        instagram.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.INSTAGRAM_EXTRA, Constants.INSTAGRAM_URL);
            startActivity(i);
        });
        youtube.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.YOUTUBE_EXTRA, Constants.YOUTUBE_URL);
            startActivity(i);
        });

        ticket.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.TICKETS_MK_EXTRA, Constants.TICKETS_MK_URL);
            startActivity(i);
        });

        viber.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.VIBER, Constants.VIBER_URL);
            startActivity(i);
        });

        tickets.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WebViewActivity.class);
            i.putExtra(Constants.TICKETS_MK_EXTRA, Constants.TICKETS_MK_URL);
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

    public void handleOnBackPressed(){
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }else {
                    finish();
                }
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    public void checkInternet(){
        NetworkMonitor networkMonitor =
                new NetworkMonitor(getApplicationContext());

        MainViewModel viewModel = new ViewModelProvider(
                this,
                new MainViewModelFactory(networkMonitor)
        ).get(MainViewModel.class);

        viewModel.isConnected().observe(this, connected -> {
            if (Boolean.TRUE.equals(connected)) {
                // online UI
                Toast.makeText(this, "✅ Connected", Toast.LENGTH_SHORT).show();
            } else {
                // offline UI
                Toast.makeText(this, "No Internet connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
