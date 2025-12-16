package com.hcvardar.manne.rkvaradr.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hcvardar.manne.rkvaradr.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by manne on 08.7.2019.
 */

public class Fragment12 extends Fragment {
    public Unbinder mUnBinder;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment12, null);
        mUnBinder = ButterKnife.bind(this, view);


        return view;
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }

   
    }
