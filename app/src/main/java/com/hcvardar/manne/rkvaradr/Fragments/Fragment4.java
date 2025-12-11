package com.hcvardar.manne.rkvaradr.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hcvardar.manne.rkvaradr.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class Fragment4 extends Fragment {
    public Unbinder mUnBinder;

    @BindView(R.id.logo1)
    ImageView logo1;
    @BindView(R.id.logo2)
    ImageView logo2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, null);
        mUnBinder = ButterKnife.bind(this, view);

        Picasso.with(getContext())
                .load("https://handball-base.com/img-club/117/17973711_1255027087949485_8352285516380875895_o.jpg")
                .into(logo1);

        Picasso.with(getContext())
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/03/REZ-Vardar.png")
                .into(logo2);

        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

   
    }
