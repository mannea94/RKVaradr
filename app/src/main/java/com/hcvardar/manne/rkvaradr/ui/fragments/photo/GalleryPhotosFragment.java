package com.hcvardar.manne.rkvaradr.ui.fragments.photo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.components.RecyclerItemClickListener;
import com.hcvardar.manne.rkvaradr.ui.activity.gallery.photo.PhotoDetailsActivity;
import com.hcvardar.manne.rkvaradr.ui.adapter.gallery.GalleryPhotoAdapter;
import com.hcvardar.manne.rkvaradr.ui.model.ImageModel;
import com.hcvardar.manne.rkvaradr.ui.model.PhotoGallery;
import com.hcvardar.manne.rkvaradr.utils.Constants;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class GalleryPhotosFragment extends Fragment {

    public Unbinder mUnBinder;

    @BindView(R.id.list)
    RecyclerView rvPhotos;
    GalleryPhotoAdapter mAdapter;
    ArrayList<ImageModel> data;

    PhotoGallery photoGallery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery_photos, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        photoGallery = new PhotoGallery();
        data = new ArrayList<>();

        if(getArguments()!=null){
            photoGallery = (PhotoGallery) getArguments().getSerializable("extra_gallery");
            if(photoGallery!=null){
                for(int i=0; i< photoGallery.getImages().size(); i++){
                    ImageModel imageModel = new ImageModel();
                    int j = i+1;
                    imageModel.setName(j + " од " + photoGallery.getImages().size());
                    imageModel.setUrl(Constants.VARDAR_UPLOADS_URL.concat(photoGallery.getImages().get(i)));
                    data.add(imageModel);
                }
            }
        }

        rvPhotos.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        rvPhotos.setHasFixedSize(true);


        mAdapter = new GalleryPhotoAdapter(requireContext(), data);
        rvPhotos.setAdapter(mAdapter);

        rvPhotos.addOnItemTouchListener(new RecyclerItemClickListener(requireContext(),
                (itemView, position) -> {
                    Intent intent1 = new Intent(requireContext(), PhotoDetailsActivity.class);
                    intent1.putParcelableArrayListExtra("data", data);
                    intent1.putExtra("pos", position);
                    startActivity(intent1);
                }));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}