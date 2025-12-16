package com.hcvardar.manne.rkvaradr.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.ui.adapter.GalleryAdapter2;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.interfaces.Row_Click_Listener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity2 extends AppCompatActivity {


    @BindView(R.id.recyclerViewGallery)
    RecyclerView recyclerView;

    GalleryAdapter2 adapter2;
    EkipaModel model;

    String url1 = "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61683890_10158140479655348_5140626153056239616_n.jpg?_nc_cat=103&_nc_oc=AQlLJQVLpYQogEGsgIZM3BmVG0QZNgmtmA0lnO7GZa_UQdzM5fLYVb2J4O57sPVkFvU&_nc_ht=scontent.fskp3-1.fna&oh=f17afecbe815d418fbe93272cd738e48&oe=5DAE7BC9";
    String url2 = "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61846509_10158135647910348_8468121889192017920_n.jpg?_nc_cat=109&_nc_oc=AQmq2-ibM5AuZglgSgrUVh3LBSEQjiEoatvlc0JKa0ERVvJXW2-Q_TVs7FUY1hjX0wE&_nc_ht=scontent.fskp3-1.fna&oh=a203a1fb40be35e95c8f6583cc7b4a90&oe=5DAF9E8B";
    String url3 = "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/61628924_10158131922235348_534977767725334528_n.jpg?_nc_cat=101&_nc_oc=AQmH5xlqZH3cQazwIIiJ-JdRMKTiU4KzmRye7ldB9pF5OC73RTGLWoOLqt781_GCHX8&_nc_ht=scontent.fskp3-1.fna&oh=f8a7f9bbdc9e45b9ee5e59d7b444664f&oe=5DC39A81";
    String url4 = "https://scontent.fskp3-1.fna.fbcdn.net/v/t1.0-9/62147781_10158141187305348_6420582138759872512_n.jpg?_nc_cat=100&_nc_oc=AQnHxLdXok3_XPZrAiIqU4wQRc960B60eiqhf40FR4Lc_PDPZfF2kSbXVnFpZR32q4Q&_nc_ht=scontent.fskp3-1.fna&oh=d98247f8319572731e0aebbd35270a53&oe=5DA79DDA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gallery2);
        ButterKnife.bind(this);


        adapter2 = new GalleryAdapter2(this, new Row_Click_Listener() {
            @Override
            public void onRowClick(EkipaModel model, int position) {
                Intent intent = new Intent(GalleryActivity2.this, GalleryActivity.class);
                intent.putExtra("extra_gallery","");
                intent.putExtra("pos_gallery",position);
                startActivity(intent);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
        getList();

//        precekSkopje.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GalleryActivity2.this, GalleryActivity.class);
//                intent.putExtra("skopje_precek","");
//                startActivity(intent);
//            }
//        });

//        vardarChampions.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GalleryActivity2.this, GalleryActivity.class);
//                intent.putExtra("vardar_champions","");
//                startActivity(intent);
//            }
//        });

    }

    public void getList(){
        ArrayList<EkipaModel> model = new ArrayList<>();
        model.add(new EkipaModel("ПРЕЧЕК НА ЕВРОПСКИОТ ПРВАК",url1));
        model.add(new EkipaModel("ПРИЕМ КАЈ ПРЕМИЕРОТ, ПРЕТСЕДАТЕЛОТ И ГРАДОНАЧАЛНИКОТ",url4));
        model.add(new EkipaModel("ВАРДАР ШАМПИОНИ 2019",url2));
        model.add(new EkipaModel("ВАРДАР - БАРСЕЛОНА (Ф4 КЕЛН 2019)",url3));
        adapter2.setItems(model);
//        adapter.notifyDataSetChanged();
    }
}
