package com.hcvardar.manne.rkvaradr.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class StrucenstabActivity extends AppCompatActivity {

    @BindView(R.id.recyclerViewStrucen)
    RecyclerView recyclerView;
    StrucenAdapter adapter;

    String imgUrl1="https://rkvardar.mk/files/team/2015/02/27/roberto-garsija-parondo-17381.png";
    String imgUrl2="https://rkvardar.mk/files/team/2015/02/27/biljana-crvenkovska-17861.png";
    String imgUrl3="https://rkvardar.mk/files/team/2015/02/27/dejan-perikj-17385.png";
    String imgUrl4="https://rkvardar.mk/files/team/2015/09/25/danijel-jurusic-13979.png";
    String imgUrl5="https://rkvardar.mk/files/team/2015/09/25/dimitar-manevski-13978.png";
    String imgUrl6="https://rkvardar.mk/files/team/2016/12/09/rubincho-srbinoski-17386.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_strucenstab);
        ButterKnife.bind(this);

        adapter = new StrucenAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        getList();

    }

    public void getList(){
        ArrayList<EkipaModel> model = new ArrayList<>();
        model.add(new EkipaModel("Роберрто Гарсија \nПарондо", imgUrl1,"главен тренер"));
        model.add(new EkipaModel("Билјана \nЦрвенковска", imgUrl2,"помошен тренер"));
        model.add(new EkipaModel("Дејан Периќ", imgUrl3,"тренер на голмани"));
        model.add(new EkipaModel("Даниел Јуришиќ", imgUrl4,"кондиционен тренер"));
        model.add(new EkipaModel("Димитар Маневски", imgUrl5,"физиотерапевт"));
        model.add(new EkipaModel("Рубинчо Србиноски", imgUrl6,"физиотерапевт"));

        adapter.setItems(model);
    }
}
