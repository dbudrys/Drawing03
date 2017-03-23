package com.dustin_domas_assignment.drawing03;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;
import org.w3c.dom.Attr;
import android.graphics.Path;
import android.widget.SeekBar;

public class DrawActivity extends View {

    private Context cont;
    private Paint drawPaint, canvasDrawable;
    private Path fingerPath;
    private Canvas canvas;
    private Bitmap bitsM;
    private int hgt;
    private int wdt;
    private float tX,xStep, tY, yStep;



    public DrawActivity(Context context){
     super(context);
        setUp(null);
 }

    public DrawActivity(Context context, AttributeSet attr){
        super(context, attr,0);
        setUp(attr);
    }

    public DrawActivity(Context context, AttributeSet attr, int defStyleAttr){
        super(context, attr, defStyleAttr);
        setUp(attr);
    }
@Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);


    drawPaint.setStyle(Paint.Style.STROKE);
    canvas.drawBitmap(bitsM, 0, 0, canvasDrawable);
    canvas.drawPath(fingerPath, drawPaint);

    drawPaint.setStyle(Paint.Style.STROKE);
    }

    private void setUp(AttributeSet attr){
        fingerPath = new Path();
        drawPaint = new Paint(Paint.DITHER_FLAG);
        canvasDrawable = new Paint(Paint.DITHER_FLAG);

        drawPaint.setStrokeWidth(15);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setAntiAlias(true);



    }

    private void startDrawing(float x, float y){
        tX = x;
        tY = y;

        fingerPath.moveTo(tX,tY);

    }

    private void touch_move(float x, float y) {
        float dx = Math.abs(x - tX);
        float dy = Math.abs(y - tY);
        if (dx >= 4 || dy >= 4) {
            fingerPath.quadTo(tX, tY, (x + tX)/2, (y + tY)/2);
            tX = x;
            tY = y;
        }
    }

    private void touch_up() {
        fingerPath.lineTo(tX, tY);
        // commit the path to our offscreen
        canvas.drawPath(fingerPath, drawPaint);
        // kill this so we don't double draw
        fingerPath.reset();
        drawPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        //mPaint.setMaskFilter(null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitsM = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitsM);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startDrawing(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:

                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                touch_up();
                invalidate();
                break;
        }
        return true;
    }




}
