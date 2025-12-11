package com.hcvardar.manne.rkvaradr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.hcvardar.manne.rkvaradr.Model.EkipaModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IgracActivity extends AppCompatActivity {

    @BindView(R.id.playerName)
    TextView name;
    @BindView(R.id.playerImage)
    ImageView image;
    @BindView(R.id.datum)
    TextView datum;
    @BindView(R.id.pozicija)
    TextView pozicija;
    @BindView(R.id.tezina)
    TextView tezina;
    @BindView(R.id.visina)
    TextView visina;
    @BindView(R.id.playerNumber)
    TextView number;
    @BindView((R.id.imgFlag))
    ImageView imgFlag;

    EkipaModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_igrac);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        int pos=0;
        if(intent.hasExtra("EXTRA")){
            model = (EkipaModel) intent.getSerializableExtra("EXTRA");
//            pos= intent.getIntExtra("POS", 0);
            name.setText(model.getIme());
            number.setText(model.getBroj());
            datum.setText(model.getDatum());
            pozicija.setText(model.getPozicija());
            tezina.setText(model.getTezina());
            visina.setText(model.getVisina());
            Picasso.with(this)
                    .load(model.getImageUrl2())
                    .fit()
                    .into(image);
            Picasso.with(this)
                    .load(new GlobalClass().checkFlag(model.getNationality()))
                    .fit()
                    .into(imgFlag);
        }

        if(intent.hasExtra("EXTRA_2")){
            model = (EkipaModel) intent.getSerializableExtra("EXTRA_2");
//            pos= intent.getIntExtra("POS", 0);
            name.setText(model.getIme());
            number.setText(model.getBroj());
            datum.setText(model.getDatum());
            pozicija.setText(model.getPozicija());
            tezina.setText(model.getTezina());
            visina.setText(model.getVisina());
            Picasso.with(this)
                    .load(model.getImageUrl2())
                    .fit()
                    .into(image);
            Picasso.with(this)
                    .load(new GlobalClass().checkFlag(model.getNationality()))
                    .fit()
                    .into(imgFlag);

        }




    }
}
