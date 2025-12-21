package com.hcvardar.manne.rkvaradr.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.activity.home.NewsActivity;
import com.hcvardar.manne.rkvaradr.ui.model.News;
import com.hcvardar.manne.rkvaradr.utils.Constants;
import com.hcvardar.manne.rkvaradr.utils.SpannableText;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class CurrentNewsFragment extends Fragment {

    public Unbinder mUnBinder;

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvParagraph)
    TextView tvParagraph;
    @BindView(R.id.ivParagraph)
    ImageView ivParagraph;
    @BindView(R.id.tvPdfInfo)
    TextView tvPDFInfo;

    News news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_news, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        news = new News();
        if(getArguments()!=null){
            news = (News) getArguments().getSerializable("current_news");
            if(news!=null){
                tvTitle.setText(news.getTitle());
                tvParagraph.setText(news.getParagraph());
                Glide.with(this)
                        .load(Constants.VARDAR_UPLOADS_URL.concat(news.getHeaderImage()))
                        .into(ivParagraph);
                if(news.report!=null){
                    ViewUtils.toVisible(tvPDFInfo);
                    SpannableText.setNewsSpannableText(requireContext(), tvPDFInfo, news.report);
                }
            }
        }

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}