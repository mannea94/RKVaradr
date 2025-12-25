package com.hcvardar.manne.rkvaradr.ui.adapter.gallery;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.hcvardar.manne.rkvaradr.ui.fragments.photo.PlaceholderFragment;
import com.hcvardar.manne.rkvaradr.ui.model.gallery.ImageModel;

import java.util.ArrayList;

public class SectionsPagerAdapter extends FragmentStateAdapter {
    public ArrayList<ImageModel> data;

    public SectionsPagerAdapter(@NonNull FragmentActivity activity,
                                ArrayList<ImageModel> data) {
        super(activity);
        this.data = data;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        ImageModel model = data.get(position);
        return PlaceholderFragment.newInstance(
                position,
                model.getName(),
                model.getUrl()
        );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
