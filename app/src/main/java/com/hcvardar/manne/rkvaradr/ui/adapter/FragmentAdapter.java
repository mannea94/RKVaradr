package com.hcvardar.manne.rkvaradr.ui.adapter;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {

    private boolean locked = false;
    private int lockedIndex;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        titles.add(title);
        fragments.add(fragment);
    }

    public void setLocked(boolean locked, int page) {
        this.locked = locked;
        lockedIndex = page;
        notifyDataSetChanged();
    }

    public ArrayList<String> titles = new ArrayList<>();
    public ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

}
