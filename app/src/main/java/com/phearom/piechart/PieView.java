package com.phearom.piechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class PieView extends View {
    private Paint big_paint;

    private int h, w = 0;

    private int[] colors = {Color.RED, Color.YELLOW, Color.CYAN, Color.GREEN, Color.BLUE};

    public PieView(Context context) {
        super(context);
        init();
    }

    public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        big_paint = new Paint();

        big_paint.setColor(Color.GRAY);
        big_paint.setAntiAlias(true);
        big_paint.setStrokeCap(Paint.Cap.BUTT);
        big_paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        w = getWidth();
        h = getHeight();

        int size = Math.max(w, h) / 2;
        int mRadius = size - (size / 3);

        int circle = mRadius * 2;

        Paint paint5 = new Paint();
        final RectF rect = new RectF();
        //Example values
        rect.set(size - mRadius, size - mRadius, size + mRadius, size + mRadius);

        big_paint.setStrokeWidth(mRadius);

        canvas.drawArc(rect, 0, circle, false, big_paint);

        Paint paint;
        int d = circle / colors.length;
        for (int i = 0; i < colors.length; i++) {
            paint = new Paint();
            paint.setStrokeWidth(mRadius);
            paint.setAntiAlias(true);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(colors[i]);
            canvas.drawArc(rect, circle / (i + 1), d, false, paint);
        }

        paint5.setColor(Color.WHITE);
        paint5.setAntiAlias(true);
        paint5.setStrokeCap(Paint.Cap.BUTT);
        paint5.setStyle(Paint.Style.FILL);
        canvas.drawCircle(size, size, size / 2, paint5);
    }

}
