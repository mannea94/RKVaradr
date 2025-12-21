package com.hcvardar.manne.rkvaradr.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;
import androidx.fragment.app.Fragment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PDFFile extends Fragment {

    private static PdfRenderer pdfRenderer;
    private static PdfRenderer.Page currentPage;
    private static ParcelFileDescriptor fileDescriptor;

    public static File downloadPdfToCache(Context c, String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            File file = new File(c.getCacheDir(), "temp.pdf");
            InputStream input = connection.getInputStream();
            FileOutputStream output = new FileOutputStream(file);

            byte[] buffer = new byte[4096];
            int count;
            while ((count = input.read(buffer)) != -1) {
                output.write(buffer, 0, count);
            }

            output.close();
            input.close();
            connection.disconnect();

            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void openPdf(File pdfFile) throws IOException {
        fileDescriptor = ParcelFileDescriptor.open(
                pdfFile,
                ParcelFileDescriptor.MODE_READ_ONLY
        );

        pdfRenderer = new PdfRenderer(fileDescriptor);
    }

    public static Bitmap renderPage(int pageIndex) {
        if (pdfRenderer.getPageCount() <= pageIndex) return null;

        if (currentPage != null) {
            currentPage.close();
        }

        currentPage = pdfRenderer.openPage(pageIndex);

        Bitmap bitmap = Bitmap.createBitmap(
                currentPage.getWidth(),
                currentPage.getHeight(),
                Bitmap.Config.ARGB_8888
        );

        currentPage.render(
                bitmap,
                null,
                null,
                PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY
        );

        return bitmap;
    }

    @Override
    public void onDestroy() {
        try {
            if (currentPage != null) currentPage.close();
            if (pdfRenderer != null) pdfRenderer.close();
            if (fileDescriptor != null) fileDescriptor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }
}
