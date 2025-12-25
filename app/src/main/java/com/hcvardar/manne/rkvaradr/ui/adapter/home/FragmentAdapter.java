package com.hcvardar.manne.rkvaradr.ui.adapter.home;


import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter {

    private final ArrayList<String> titles = new ArrayList<>();
    private final ArrayList<Fragment> fragments = new ArrayList<>();

    public FragmentAdapter(@NonNull FragmentActivity activity) {
        super(activity);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addFragment(Fragment fragment, String title) {
        fragments.add(fragment);
        titles.add(title);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public String getTitle(int position) {
        return titles.get(position);
    }

}
