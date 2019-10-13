package com.hcvardar.manne.rkvaradr.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.hcvardar.manne.rkvaradr.Adapter.StrucenAdapter;
import com.hcvardar.manne.rkvaradr.Model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RakovodtsvoActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewStrucen)
    RecyclerView recyclerView;
    StrucenAdapter adapter;

    String imgUrl1="https://rkvardar.mk/files/team/2015/02/27/sergej-samsonenko-1012.png";
    String imgUrl2="https://rkvardar.mk/files/team/2015/02/27/davor-stojanoski-2178.png";
    String imgUrl3="https://rkvardar.mk/files/team/2015/02/27/marko-savovski-2177.png";
    String imgUrl4="https://rkvardar.mk/files/team/2016/10/14/eduard-koksharov-8509.png";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rakovodstvo);
        ButterKnife.bind(this);

        adapter = new StrucenAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getList();

    }

    public void getList(){
        ArrayList<EkipaModel> model = new ArrayList<>();
        model.add(new EkipaModel("Сергеј Самсоненко", imgUrl1,"претседател"));
        model.add(new EkipaModel("Давор Стојаноски", imgUrl2,"извршен директор"));
        model.add(new EkipaModel("Марко Савовски", imgUrl3,"оперативен менаџер"));
        model.add(new EkipaModel("Едуард Кокшаров", imgUrl4,"спортски директор"));


        adapter.setItems(model);
    }
}
