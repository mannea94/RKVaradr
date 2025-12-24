package com.hcvardar.manne.rkvaradr.utils;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Toast;

public class ViewUtils {

    public static int width = 400;
    public static int height = 400;

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

    public static void showToastMessage(Context c, String message){
        Toast.makeText(c, message,
                Toast.LENGTH_LONG).show();
    }


}