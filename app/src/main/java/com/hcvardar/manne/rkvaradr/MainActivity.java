package com.hcvardar.manne.rkvaradr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.google.android.material.navigation.NavigationView;
import com.hcvardar.manne.rkvaradr.Activity.GalleryActivity2;
import com.hcvardar.manne.rkvaradr.Activity.RakovodtsvoActivity;
import com.hcvardar.manne.rkvaradr.Activity.StrucenstabActivity;
import com.hcvardar.manne.rkvaradr.Adapter.MyPageAdapter;
import com.hcvardar.manne.rkvaradr.Adapter.MyPageAdapter2;
import com.hcvardar.manne.rkvaradr.Adapter.PlayerAdapter;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment1;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment10;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment11;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment12;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment13;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment2;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment3;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment4;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment5;
import com.hcvardar.manne.rkvaradr.Fragments.Fragment6;
import com.hcvardar.manne.rkvaradr.Model.EkipaData;
import com.hcvardar.manne.rkvaradr.Model.EkipaModel;
import com.hcvardar.manne.rkvaradr.Model.InternetConnection;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.SliderDots)
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;
    MyPageAdapter viewPagerAdapter;

    @BindView(R.id.viewPager2)
    ViewPager viewPager2;
    @BindView(R.id.SliderDots2)
    LinearLayout sliderDotspanel2;
    private int dotscount2;
    private ImageView[] dots2;
    MyPageAdapter2 viewPagerAdapter2;

    @BindView(R.id.sponzor1)
    ImageView sponzor1;
    @BindView(R.id.sponzor2)
    ImageView sponzor2;
    @BindView(R.id.sponzor3)
    ImageView sponzor3;
    @BindView(R.id.sponzor4)
    ImageView sponzor4;
    @BindView(R.id.sponzor5)
    ImageView sponzor5;
    @BindView(R.id.sponzor6)
    ImageView sponzor6;
    @BindView(R.id.sponzor7)
    ImageView sponzor7;
    @BindView(R.id.sponzor8)
    ImageView sponzor8;
    @BindView(R.id.sponzor9)
    ImageView sponzor9;
    @BindView(R.id.sponzor10)
    ImageView sponzor10;
    @BindView(R.id.sponzor11)
    ImageView sponzor11;
    @BindView(R.id.sponzor12)
    ImageView sponzor12;
    @BindView(R.id.sponzor13)
    ImageView sponzor13;
    @BindView(R.id.sponzor14)
    ImageView sponzor14;
    @BindView(R.id.sponzor15)
    ImageView sponzor15;
    @BindView(R.id.sponzor16)
    ImageView sponzor16;
    @BindView(R.id.sponzor17)
    ImageView sponzor17;

    @BindView(R.id.karticka)
    ImageView karticka;

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


        viewPagerAdapter =  new MyPageAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Fragment1());
        viewPagerAdapter.addFragment(new Fragment3());
        viewPagerAdapter.addFragment(new Fragment2());
        viewPagerAdapter.addFragment(new Fragment4());
        viewPagerAdapter.addFragment(new Fragment5());
        viewPagerAdapter.addFragment(new Fragment6());
        viewPager.setAdapter(viewPagerAdapter);
        setUpViewDots();

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

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/08/Vardar-tim-scaled.jpg")
                .fit()
                .into(imgCover);

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/06/pehari_web_naslovna5.jpg")
                .fit()
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KlubActivity.class);
                startActivity(intent);
//                finish();
            }
        });

        Picasso.get()
                .load("https://vardarfanshop.com/image/catalog/Baneri/Baner_novdres2526B.jpg")
//                .fit()
                .into(onlineStore);

        onlineStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vardarfanshop.com/index.php?route=common/home"));
                startActivity(browserIntent);
            }
        });
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rkvardar.mk/"));
                startActivity(browserIntent);
            }
        });

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2019/05/NLB_Banka_temno-2.jpg")
                .fit()
                .into(sponzor1);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2019/05/KOM-BANK_web3.png")
                .fit()
                .into(sponzor2);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/02/20.-Ministerstvo-za-sport-1-480x149.jpg")
                .fit()
                .into(sponzor3);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/09/SPARKASSE_L_web2.jpg")
                .into(sponzor4);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2022/12/Pelisterka-logo-res-768x247.jpg")
                .fit()
                .into(sponzor5);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/08/Neuromedica_web.png")
                .fit()
                .into(sponzor6);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2022/12/Kempa_web.png")
                .fit()
                .into(sponzor7);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/09/fokabo_web-300x119.png")
                .fit()
                .into(sponzor8);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2019/05/vat.jpg")
                .fit()
                .into(sponzor9);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2019/05/VLT_logo.png")
                .fit()
                .into(sponzor10);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2024/09/MTEL_web.png")
                .fit()
                .into(sponzor11);
        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2025/11/ALPE-BANKA-Logotipi.png")
                .fit()
                .into(sponzor12);
        Picasso.get()
                .load("https://rkvardar.mk/files/sponsor/2017/08/11/lyoness-13488.png")
                .fit()
                .into(sponzor13);
        Picasso.get()
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/happy-card-19231.jpg")
                .fit()
                .into(sponzor14);
        Picasso.get()
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/swisslion-19229.jpg")
                .fit()
                .into(sponzor15);
        Picasso.get()
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/olimpiko-14725.jpg")
                .fit()
                .into(sponzor16);
        Picasso.get()
                .load("https://rkvardar.mk/files/sponsor/2018/10/01/cityradio-17638.png")
                .fit()
                .into(sponzor17);

        Picasso.get()
                .load("https://rkvardar.mk/files/page/2015/01/20/za-klubot-18307.png")
                .fit()
                .into(karticka);

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
        adapter.setItems(new GlobalClass().getList(this, true));
        adapter.notifyDataSetChanged();

        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rkvardar"));
                startActivity(browserIntent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/hcvardar"));
                startActivity(browserIntent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://rkvardar.mk/kontakt"));
                startActivity(browserIntent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCE_u5UqJnb9-0XO4soCEgUQ/featured"));
                startActivity(browserIntent);
            }
        });

        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ticketplus.mk/"));
                startActivity(browserIntent);
            }
        });

        karticka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vardar-cashback.mk/mk-va?utm_medium=website&utm_source=vardar&utm_campaign=nov18&utm_content=banner"));
                startActivity(browserIntent);
            }
        });

        league1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ehfel.eurohandball.com/men/2025-26/"));
                startActivity(browserIntent);
            }
        });

        league2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ehfel.eurohandball.com/men/2025-26/ehf-finals-men-2026/about-the-event/general-information/"));
                startActivity(browserIntent);
            }
        });

        league3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ehftv.com/"));
                startActivity(browserIntent);
            }
        });


    }


    public void setUpViewDots(){
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

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


}
