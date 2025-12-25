package com.hcvardar.manne.rkvaradr.components;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;


public class ShieldImageView extends AppCompatImageView {

    private Path clipPath = new Path();
    private float inset;

    public ShieldImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        inset = getResources().getDisplayMetrics().density * 6; // 6dp safe inset
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        clipPath.reset();

        float left   = inset;
        float right  = w - inset;
        float top    = inset;
        float bottom = h - inset;

        float midX = w / 2f;

        // Top flat section
        clipPath.moveTo(left + w * 0.12f, top);
        clipPath.lineTo(right - w * 0.12f, top);

        // Upper rounded sides
        clipPath.quadTo(right, top + h * 0.08f, right, top + h * 0.30f);

        // KEEP WIDTH until lower section
        clipPath.lineTo(right - w * 0.10f, top + h * 0.65f);

        // Bottom taper (smooth)
        clipPath.quadTo(
                midX, bottom,
                left + w * 0.10f, top + h * 0.65f
        );

        // Left side up
        clipPath.lineTo(left, top + h * 0.30f);
        clipPath.quadTo(left, top + h * 0.08f, left + w * 0.12f, top);

        clipPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(clipPath);
        super.onDraw(canvas);
    }
}



