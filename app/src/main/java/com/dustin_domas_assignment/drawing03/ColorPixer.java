package com.dustin_domas_assignment.drawing03;

import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dustinlobato on 3/23/17.
 */

public class ColorPixer extends Dialog{

    float cordinate_x, cordinate_y;
    double bitsW, bitsH;
    private onColorpickListener listener;
    private int colorPix;
    ImageView colorPalette;
    Bitmap bitsCanvas;
    TextView colorSwatch;
    Canvas imageCanvas;



    public interface onColorpickListener{
        void colorChanged();

    }

    public ColorPixer(Context context, int color, onColorpickListener listener) {
        super(context);
        this.colorPix = color;
        this.listener = listener;

        //setUp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }


    public boolean onTouchEvent(MotionEvent motion ){

        cordinate_x = motion.getX();
        cordinate_y = motion.getY();



        return true;
    }

    protected void onDraw(Canvas canvas){

    }

    public void  changeColor(int color){

         colorPalette = (ImageView) findViewById(R.id.imageView);
       // colorPalette.setImageResource(R.drawable.colorwheel);
         bitsCanvas = ((BitmapDrawable)colorPalette.getDrawable()).getBitmap();
        //BitmapDrawable bitsImage = (BitmapDrawable)

    }




    private class ColorView extends View {

        private onColorpickListener listener;
        private Paint paint;



        public ColorView(Context context, int paint, onColorpickListener l) {
            super(context);



        }
        @Override
        protected void onDraw(Canvas canvas){

        }
    }


}
