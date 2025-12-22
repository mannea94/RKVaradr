package com.hcvardar.manne.rkvaradr.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.model.EkipaModel;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.GlobalClass;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PlayerFragment extends Fragment {

    public Unbinder mUnBinder;

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        DrawableImageViewTarget divt = new DrawableImageViewTarget(imgTriangle);
        Glide.with(this).load(R.drawable.triangle_icon).into(divt.getView());

        model = new EkipaModel();
        if(getArguments()!=null){
            model = (EkipaModel) getArguments().getSerializable("current_player");
            if(model!=null){
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

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}