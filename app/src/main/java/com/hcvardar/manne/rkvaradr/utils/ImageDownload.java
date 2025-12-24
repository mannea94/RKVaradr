package com.hcvardar.manne.rkvaradr.utils;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;

import com.hcvardar.manne.rkvaradr.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.Executors;

public class ImageDownload {

    public static void downloadImage(Context context, String imageUrl, int versionCode) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();

                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                if(versionCode >= Build.VERSION_CODES.Q)
                    saveToGallery(context, bitmap);
                else
                    saveToGallery(bitmap, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void saveToGallery(Context context, Bitmap bitmap) {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DISPLAY_NAME, "image_" + System.currentTimeMillis() + ".jpg");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg");
        values.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES + "/MyApp");

        Uri uri = context.getContentResolver()
                .insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

        try (OutputStream out = context.getContentResolver().openOutputStream(Objects.requireNonNull(uri))) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, Objects.requireNonNull(out));
            ((Activity)context).runOnUiThread(() ->
                    ViewUtils.showToastMessage(context, context.getResources().getString(R.string.image_saved_to_gallery)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToGallery(Bitmap bitmap, Context context) {
        File picturesDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES + "/MyApp");

        if (!picturesDir.exists()) {
            picturesDir.mkdirs();
        }

        File imageFile = new File(
                picturesDir,
                "IMG_" + System.currentTimeMillis() + ".jpg"
        );

        try (FileOutputStream out = new FileOutputStream(imageFile)) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            ((Activity)context).runOnUiThread(() ->
                    ViewUtils.showToastMessage(context, context.getResources().getString(R.string.image_saved_to_gallery)));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void downloadAndShareImage(Context context, String imageUrl) {
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                URL url = new URL(imageUrl);
                Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());

                File cachePath = new File(context.getCacheDir(), "images");
                cachePath.mkdirs();

                File file = new File(cachePath, "shared_image.png");
                FileOutputStream stream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                stream.close();

                Uri contentUri = FileProvider.getUriForFile(
                        context,
                        context.getPackageName() + ".provider",
                        file
                );

                ((Activity)context).runOnUiThread(() -> shareImage(context, contentUri));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void shareImage(Context context, Uri imageUri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        context.startActivity(Intent.createChooser(shareIntent, "Share Image"));
    }


}
