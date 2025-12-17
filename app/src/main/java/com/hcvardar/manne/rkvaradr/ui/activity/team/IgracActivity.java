package com.hcvardar.manne.rkvaradr.ui.activity.team;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.Constants;
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
    @BindView(R.id.imgTriangle)
    ImageView imgTriangle;

    EkipaModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_igrac);
        ButterKnife.bind(this);

        DrawableImageViewTarget divt = new DrawableImageViewTarget(imgTriangle);
        Glide.with(this).load(R.drawable.triangle_icon).into(divt.getView());

        Intent intent = getIntent();
        int pos=0;
        if(intent.hasExtra("EXTRA")){
            model = (EkipaModel) intent.getSerializableExtra("EXTRA");
            name.setText(model.getIme());
            number.setText(model.getBroj());
            datum.setText(model.getDatum());
            pozicija.setText(model.getPozicija());
            tezina.setText(model.getTezina());
            visina.setText(model.getVisina());
            Picasso.get()
                    .load(Constants.VARDAR_UPLOADS_URL.concat(model.getImageUrl2()))
                    .fit()
                    .into(image);
            Picasso.get()
                    .load(new GlobalClass().checkFlag(model.getNationality()))
                    .fit()
                    .into(imgFlag);
        }

        if(intent.hasExtra("EXTRA_2")){
            model = (EkipaModel) intent.getSerializableExtra("EXTRA_2");
            name.setText(model.getIme());
            number.setText(model.getBroj());
            datum.setText(model.getDatum());
            pozicija.setText(model.getPozicija());
            tezina.setText(model.getTezina());
            visina.setText(model.getVisina());
            Picasso.get()
                    .load(Constants.VARDAR_UPLOADS_URL.concat(model.getImageUrl2()))
                    .fit()
                    .into(image);
            Picasso.get()
                    .load(new GlobalClass().checkFlag(model.getNationality()))
                    .fit()
                    .into(imgFlag);

        }




    }
}
