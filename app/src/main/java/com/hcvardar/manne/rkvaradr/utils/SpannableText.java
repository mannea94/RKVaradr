package com.hcvardar.manne.rkvaradr.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.hcvardar.manne.rkvaradr.R;
import com.hcvardar.manne.rkvaradr.ui.activity.home.NewsActivity;
import com.hcvardar.manne.rkvaradr.ui.fragments.PDFPreviewFragment;
import com.hcvardar.manne.rkvaradr.ui.model.Report;

public class SpannableText {

    public static void setNewsSpannableText(Context context, TextView tvMatchInfo , Report report){
        SpannableStringBuilder builderMatchInfo = new SpannableStringBuilder();

        String reportInfo = context.getResources().getString(R.string.report_info);
        SpannableString nameSpannableReport = new SpannableString(reportInfo + "\n");
        nameSpannableReport.setSpan(new ForegroundColorSpan(context.getColor(R.color.white)), 0, nameSpannableReport.length(), 0);
        builderMatchInfo.append(nameSpannableReport);

        String matchInfo = report.getMatchInfo();
        SpannableString termsSpannable = new SpannableString(matchInfo + "\n");
        ClickableSpan clickableSpanTerms = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                if(report.getPdfUrl()!=null){
                    PDFPreviewFragment fragment = new PDFPreviewFragment();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pdf_url", Constants.VARDAR_UPLOADS_URL.concat(report.getPdfUrl()));
                    fragment.setArguments(bundle);
                    ((NewsActivity)context).replaceFragment(fragment);
                }
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.bgColor = Color.TRANSPARENT;
                ds.setUnderlineText(false);
            }
        };

        termsSpannable.setSpan(clickableSpanTerms, 0, termsSpannable.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        termsSpannable.setSpan(new ForegroundColorSpan(context.getColor(R.color.red)), 0, termsSpannable.length(), 0);
        termsSpannable.setSpan(new StyleSpan(Typeface.BOLD), 0, termsSpannable.length(), 0);
        builderMatchInfo.append(termsSpannable);


        tvMatchInfo.setMovementMethod(LinkMovementMethod.getInstance());
        tvMatchInfo.setText(builderMatchInfo, TextView.BufferType.SPANNABLE);
    }
}
