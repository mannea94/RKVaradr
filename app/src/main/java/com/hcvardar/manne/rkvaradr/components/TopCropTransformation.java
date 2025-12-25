package com.hcvardar.manne.rkvaradr.components;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

public class TopCropTransformation extends BitmapTransformation {
    @Override
    protected Bitmap transform(
            @NonNull BitmapPool pool,
            @NonNull Bitmap toTransform,
            int outWidth,
            int outHeight) {

        if (toTransform.getWidth() == outWidth &&
                toTransform.getHeight() == outHeight) {
            return toTransform;
        }

        float scale = Math.max(
                (float) outWidth / toTransform.getWidth(),
                (float) outHeight / toTransform.getHeight()
        );

        int scaledWidth = Math.round(scale * toTransform.getWidth());
        int scaledHeight = Math.round(scale * toTransform.getHeight());

        Bitmap result = pool.get(outWidth, outHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(result);
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);
        matrix.postTranslate(
                (outWidth - scaledWidth) / 2f,
                0 // TOP crop
        );

        Paint paint = new Paint(Paint.FILTER_BITMAP_FLAG);
        canvas.drawBitmap(toTransform, matrix, paint);

        return result;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update("top_crop_v1".getBytes(CHARSET));
    }
}
