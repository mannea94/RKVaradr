package com.hcvardar.manne.rkvaradr.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by manne on 10.12.2017.
 */

public class MyPageAdapter2 extends FragmentPagerAdapter {
    public MyPageAdapter2(FragmentManager fm) {
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
