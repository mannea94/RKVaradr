package com.hcvardar.manne.rkvaradr.utils;

import static android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

public class ViewUtils {

    public static int width = 400;
    public static int height = 400;

    public static int width_blog = 1200;
    public static int height_blog = 1200;

    public static void needShow(View v, boolean show) {
        if (v == null) return;

        if (show) toVisible(v);
        else toGone(v);
    }

    public static void needShow(boolean show, View... v) {
        if (v == null) return;

        for (View view : v) {
            if (show) toVisible(view);
            else toGone(view);
        }
    }

    public static void toVisible(View v) {
        if (v == null) return;
        v.setVisibility(View.VISIBLE);
    }

    public static void toGone(View v) {
        if (v == null) return;
        v.setVisibility(View.GONE);
    }

    public static int getDp(int pixels) {
        return (int) (Resources.getSystem().getDisplayMetrics().density * pixels);
    }

    public static float getDp(float pixels) {
        return Resources.getSystem().getDisplayMetrics().density * pixels;
    }

    public static int getHeight(Context c){
        return Integer.parseInt(String.valueOf(c.getResources().getDisplayMetrics().heightPixels));
    }

    public static int getWidth(Context c){
        return Integer.parseInt(String.valueOf(c.getResources().getDisplayMetrics().widthPixels));
    }

    public static void showStatusBar(Activity c) {
        if (Build.VERSION.SDK_INT < 16) {
            c.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            View decorView = c.getWindow().getDecorView();
            // Show Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    public static void hideStatusBar(Activity c) {
        // Hide Status Bar
        if (Build.VERSION.SDK_INT < 16) {
             c.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            View decorView = c.getWindow().getDecorView();
            // Hide Status Bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }


}