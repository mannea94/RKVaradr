package com.hcvardar.manne.rkvaradr.ui.adapter.gallery;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hcvardar.manne.rkvaradr.ui.fragments.photo.PlaceholderFragment;
import com.hcvardar.manne.rkvaradr.ui.model.ImageModel;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    public ArrayList<ImageModel> data = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager fm, ArrayList<ImageModel> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position, data.get(position).getName(), data.get(position).getUrl());
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data.get(position).getName();
    }
}
