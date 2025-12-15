package com.hcvardar.manne.rkvaradr.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hcvardar.manne.rkvaradr.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class Fragment2 extends Fragment {
    public Unbinder mUnBinder;

    @BindView(R.id.logo1)
    ImageView logo1;
    @BindView(R.id.logo2)
    ImageView logo2;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, null);
        mUnBinder = ButterKnife.bind(this, view);

        Picasso.get()
                .load("https://rkvardar.com.mk/wp-content/uploads/2023/03/REZ-Vardar.png")
                .into(logo1);

        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/en/3/3d/Fenix_Toulouse_handball_club.png")
                .into(logo2);

        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

   
    }
