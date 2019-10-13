package com.hcvardar.manne.rkvaradr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.hcvardar.manne.rkvaradr.Adapter.EkipaAdapter;
import com.hcvardar.manne.rkvaradr.Model.EkipaData;
import com.hcvardar.manne.rkvaradr.Model.EkipaModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EkipaActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewPeople)
    RecyclerView recyclerView;
    EkipaAdapter adapter;
    EkipaData data;
    EkipaModel model;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ekipa);
        ButterKnife.bind(this);
        model=new EkipaModel();
        data=new EkipaData();
//        Intent intent = getIntent();
        adapter = new EkipaAdapter(this, new Row_Click_Listener() {
            @Override
            public void onRowClick(EkipaModel model, int position) {
                Intent intent = new Intent(EkipaActivity.this, IgracActivity.class);
                intent.putExtra("EXTRA", model);
                intent.putExtra("POS", position);
                startActivity(intent);
            }
        });
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
//        generateList();

        getList();

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

//    @Override
//    protected void onResume() {
//        super.onResume();
//        adapter.setItems(generateList());
//        adapter.notifyDataSetChanged();
//    }

//    ArrayList<EkipaModel> generateList(){
//        EkipaData data = PreferencesManager.getPlayers(this);
//        return data.models;
//    }
}
