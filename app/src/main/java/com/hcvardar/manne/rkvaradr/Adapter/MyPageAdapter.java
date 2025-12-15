package com.hcvardar.manne.rkvaradr.Adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by manne on 10.12.2017.
 */

public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment){

        fragments.add(fragment);
    }


    public ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
