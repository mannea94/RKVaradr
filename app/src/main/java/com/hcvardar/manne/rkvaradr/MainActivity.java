package com.hcvardar.manne.rkvaradr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

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
    GifImageView tickets;

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
    @BindView(R.id.league4)
    ImageView league4;

    String uri1="https://rkvardar.mk/files/team/2017/09/27/dainis-krishtopans-13981.png";
    String uri2="https://rkvardar.mk/files/team/2015/02/27/igor-karachikj-13950.png";
    String uri3="https://rkvardar.mk/files/team/2014/12/23/stojanche-stoilov-13962.png";
    String uri4="https://rkvardar.mk/files/team/2018/08/30/stash-skube-17333.png";
    String uri5="https://rkvardar.mk/files/team/2017/09/27/janja-vojvodikj-13985.png";
    String uri6="https://rkvardar.mk/files/team/2018/08/30/sergei-gorbok-17339.png";
    String uri7="https://rkvardar.mk/files/team/2016/10/05/vuko-borozan-13951.png";
    String uri8="https://rkvardar.mk/files/team/2018/10/26/kristian-disinger-17839.png";
    String uri9="https://rkvardar.mk/files/team/2018/09/01/marko-mishevski-17360.png";
    String uri10="https://rkvardar.mk/files/team/2018/08/30/dimitri-kiseljev-17343.png";
    String uri12="https://rkvardar.mk/files/team/2016/10/04/fereira-moraes-rozherio-13963.png";
    String uri13="https://rkvardar.mk/files/team/2018/08/30/gleb-kalarash-17327.png";
    String uri14="https://rkvardar.mk/files/team/2016/10/05/vlado-nedanovski-13967.png";
    String uri15="https://rkvardar.mk/files/team/2015/01/20/timur-dibirov-13966.png";
    String uri16="https://rkvardar.mk/files/team/2015/01/22/daniil-shishkarev-13972.png";
    String uri17="https://rkvardar.mk/files/team/2016/10/04/ivan-chupikj-13973.png";
    String uri18="https://rkvardar.mk/files/team/2016/10/04/martin-popovski-13970.png";
    String uri19="https://rkvardar.mk/files/team/2018/10/11/kalifa-gedban-17770.png";
    String uri20="https://rkvardar.mk/files/team/2018/08/30/dejan-milosavljev-17341.png";
    String uri21="https://rkvardar.mk/files/team/2018/09/03/marko-kizikj-17372.png";
    String uri22="https://rkvardar.mk/files/team/2018/09/01/andrej-petkovski-17362.png";


    String url1="https://rkvardar.mk/files/styles/juicebox_small/public/team/2017/09/27/dainis-krishtopans-13980.png?itok=cSJMzQdr";
    String url2="https://rkvardar.mk/files/styles/juicebox_small/public/team/2015/02/27/igor-karachikj-13949.png?itok=5hwZuVYr";
    String url3="https://rkvardar.mk/files/styles/juicebox_small/public/team/2014/12/23/stojanche-stoilov-13961.png?itok=ijdUe97G";
    String url4="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/08/30/stash-skube-17336.png?itok=KIsOMpXD";
    String url5="https://rkvardar.mk/files/styles/juicebox_small/public/team/2017/09/27/janja-vojvodikj-13984.png?itok=9EZ9QD34";
    String url6="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/08/30/sergei-gorbok-17337.png?itok=deD30ZP8";
    String url7="https://rkvardar.mk/files/styles/juicebox_small/public/team/2016/10/05/vuko-borozan-13952.png?itok=pHbxqEig";
    String url8="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/10/26/kristian-disinger-17841.png?itok=GO-4tLVn";
    String url9="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/09/01/marko-mishevski-17359.png?itok=3HDOZ7to";
    String url10="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/08/30/dimitri-kiseljev-17342.png?itok=YDBHn25d";
    String url12="https://rkvardar.mk/files/styles/juicebox_small/public/team/2016/10/04/fereira-moraes-rozherio-13964.png?itok=cTKGmiC8";
    String url13="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/08/30/gleb-kalarash-17338.png?itok=SFh_-qpf";
    String url14="https://rkvardar.mk/files/styles/juicebox_small/public/team/2016/10/05/vlado-nedanovski-17842.png?itok=kRZbleM6";
    String url15="https://rkvardar.mk/files/styles/juicebox_small/public/team/2015/01/20/timur-dibirov-13965.png?itok=2F1CxjLF";
    String url16="https://rkvardar.mk/files/styles/juicebox_small/public/team/2015/01/22/daniil-shishkarev-13971.png?itok=KbhBdwxX";
    String url17="https://rkvardar.mk/files/styles/juicebox_small/public/team/2016/10/04/ivan-chupikj-13974.png?itok=tPD3v9ot";
    String url18="https://rkvardar.mk/files/styles/juicebox_small/public/team/2016/10/04/martin-popovski-13969.png?itok=YEBRFzja";
    String url19="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/10/11/kalifa-gedban-17769.png?itok=vESwQ-Pw";
    String url20="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/08/30/dejan-milosavljev-17340.png?itok=ptKZo2kn";
    String url21="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/09/03/marko-kizikj-17371.png?itok=tPg2wSFo";
    String url22="https://rkvardar.mk/files/styles/juicebox_small/public/team/2018/09/01/andrej-petkovski-17361.png?itok=Kgd-wjzE";

    InternetConnection internetConnection;
    CheckConnection checkConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        viewPagerAdapter =  new MyPageAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new Fragment1());
        viewPagerAdapter.addFragment(new Fragment2());
        viewPagerAdapter.addFragment(new Fragment3());
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

        Picasso.with(this)
                .load("https://rkvardar.mk/files/page/2015/01/20/za-klubot-20947.jpg")
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

        Picasso.with(this)
                .load("https://rkvardar.mk/files/page/2015/01/20/za-klubot-20636.png")
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

        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/betcity-14044.jpg")
                .fit()
                .into(sponzor1);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/hotel-russia-19228.png")
                .fit()
                .into(sponzor2);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/sc-jane-sandanski-30.png")
                .fit()
                .into(sponzor3);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/sistina-7618.jpg")
                .into(sponzor4);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/antena-5-19227.png")
                .fit()
                .into(sponzor5);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/gorska-19225.png")
                .fit()
                .into(sponzor6);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/triglav-19224.png")
                .fit()
                .into(sponzor7);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/nlb-14726.jpg")
                .fit()
                .into(sponzor8);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/hummel-19223.png")
                .fit()
                .into(sponzor9);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2014/12/24/t-mobile-19226.png")
                .fit()
                .into(sponzor10);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/02/27/balkan-construction-group-230.png")
                .fit()
                .into(sponzor11);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/09/15/pechatnica-dule99-2499.png")
                .fit()
                .into(sponzor12);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2017/08/11/lyoness-13488.png")
                .fit()
                .into(sponzor13);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/happy-card-19231.jpg")
                .fit()
                .into(sponzor14);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/swisslion-19229.jpg")
                .fit()
                .into(sponzor15);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2017/11/17/olimpiko-14725.jpg")
                .fit()
                .into(sponzor16);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2018/10/01/cityradio-17638.png")
                .fit()
                .into(sponzor17);

        Picasso.with(this)
                .load("https://rkvardar.mk/files/page/2015/01/20/za-klubot-18307.png")
                .fit()
                .into(karticka);

        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/01/13/seha-2494.png")
                .fit()
                .into(league1);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/01/13/ehf-final-4-20399.png")
                .fit()
                .into(league2);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/01/13/ehf-tv-2451.png")
                .fit()
                .into(league3);
        Picasso.with(this)
                .load("https://rkvardar.mk/files/sponsor/2015/01/13/velux-17811.jpg")
                .fit()
                .into(league4);

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
        getList();
//        generateList();

//        internetConnection.checkInternet(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });





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
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.seha-liga.com/"));
                startActivity(browserIntent);
            }
        });

        league2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ehffinal4.com/"));
                startActivity(browserIntent);
            }
        });

        league3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ehftv.com/int/"));
                startActivity(browserIntent);
            }
        });

        league4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ehfcl.com/"));
                startActivity(browserIntent);
            }
        });

    }

    public void getList(){
        ArrayList<EkipaModel> model = new ArrayList<>();
        model.add(new EkipaModel("Сташ \nСкубе", uri4, url4, "15 ноември 1989", "среден бег", "85kg", "179cm","20"));
        model.add(new EkipaModel("Игор \nКарачиќ", uri2, url2, "2 ноември 1988", "среден бег", "94kg", "192cm","18"));
        model.add(new EkipaModel("Јања \nВојводиќ", uri5, url5, "2 ноември 1988", "среден бег", "72kg", "180cm","37"));
        model.add(new EkipaModel("Сергеи \nГорбок", uri6, url6, "4 декември 1982", "лев бег", "98kg", "196cm","32"));
        model.add(new EkipaModel("Вуко \nБорозан", uri7, url7, "9 април 1994", "лев бег", "105kg", "203cm","34"));
        model.add(new EkipaModel("Криситиан \nДисингер", uri8, url8, "15 ноември 1991", "лев бег", "102kg", "202cm","15"));
        model.add(new EkipaModel("Марко \nМишевски", uri9, url9, "23 август 1999", "лев бег", "92kg", "199cm","97"));
        model.add(new EkipaModel("Димитри \nКисељев", uri10, url10, "15 ноември 1994", "десен бег", "98kg", "193cm","50"));
        model.add(new EkipaModel("Данис \nКриштопанс", uri1, url1, "31 мај 1995", "десен бег","135kg","215cm","10"));
        model.add(new EkipaModel("Фереира \nМораеш \nРожеиро", uri12, url12, "11 јануари 1994", "пикер","125kg","204cm","13"));
        model.add(new EkipaModel("Стојанче \nСтоилов", uri3, url3, "30 април 1987", "пикер", "110kg", "191cm","5"));
        model.add(new EkipaModel("Глеб \nКалараш", uri13, url13, "29 ноември 1990", "пикер","95kg","205cm","21"));
        model.add(new EkipaModel("Владо \nНедановски", uri14, url14, "23 јуни 1985", "лево крило","90kg","187cm","7"));
        model.add(new EkipaModel("Тимур \nДибиров", uri15, url15, "30 јули 1983", "лево крило","74kg","180cm","31"));
        model.add(new EkipaModel("Даниил \nШишкарев", uri16, url16, "6 јули 1988", "десно крило","85kg","190cm","33"));
        model.add(new EkipaModel("Иван \nЧупиќ", uri17, url17, "27 март 1986", "десно крило","78kg","178cm","27"));
        model.add(new EkipaModel("Мартин \nПоповски", uri18, url18, "26 август 1994", "десно крило","70kg","177cm","9"));
        model.add(new EkipaModel("Калифа \nГедбан", uri19, url19, "/", "голман","/","200cm","22"));
        model.add(new EkipaModel("Дејан \nМилосављев", uri20, url20, "16 март 1996", "голман","110кg","196cm","96"));
        model.add(new EkipaModel("Марко \nКизиќ", uri21, url21, "22 јануари 2001", "голман","89кg","190cm","98"));
        model.add(new EkipaModel("Андреј \nПетковски", uri22, url22, "30 мај 2001", "голман","90кg","188cm","99"));


        adapter.setItems(model);
//        adapter.notifyDataSetChanged();
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
