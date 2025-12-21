package com.hcvardar.manne.rkvaradr.ui.fragments;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.barteksc.pdfviewer.PDFView;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.utils.PDFFile;
import com.hcvardar.manne.rkvaradr.utils.ViewUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class PDFPreviewFragment extends Fragment {

    public Unbinder mUnBinder;

    @BindView(R.id.pdfView)
    PDFView pdfView;

    @BindView(R.id.pdfImage)
    ImageView pdfImage;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    String pdfUri;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_p_d_f_preview, container, false);
        mUnBinder = ButterKnife.bind(this, view);

        pdfView.setBackgroundColor(Color.LTGRAY);

        if(getArguments()!=null) {
            pdfUri = getArguments().getString("pdf_url");
            if(pdfUri!=null) {
                ViewUtils.toVisible(progressBar);
                loadPdfFromUrl(pdfUri);
            }
        }

        return view;
    }



    private void loadPdfFromUrl(String urlString) {
        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executor.execute(() -> {
            File pdfFile = PDFFile.downloadPdfToCache(requireContext(), urlString);
            handler.post(() -> {
                if (pdfFile != null) {
                    // Android 15+
                    ViewUtils.toGone(progressBar);
                    if (Build.VERSION.SDK_INT >= 35) {
                        ViewUtils.toGone(pdfView);
                        pdfImage.setBackgroundColor(Color.WHITE);
                        try {
                            PDFFile.openPdf(pdfFile);
                            Bitmap firstPage = PDFFile.renderPage(0);
                            Glide.with(this)
                                            .load(firstPage)
                                                    .into(pdfImage);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        ViewUtils.toGone(pdfImage);
                        pdfView.fromFile(pdfFile).load();
                    }

                } else {
                    Toast.makeText(requireActivity(),
                            "Failed to load PDF",
                            Toast.LENGTH_SHORT).show();
                    ViewUtils.toGone(progressBar);
                }
            });
        });
    }

}