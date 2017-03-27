package com.dustin_domas_assignment.drawing03;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dustinlobato on 3/23/17.
 */

public class ColorPixer extends Dialog implements View.OnClickListener {

    private float  cordinate_x;
    private float cordinate_y;

    private int pixel;
    private int color;
   DrawActivity drawColor;

    ImageView colorPalette;
    Button colorButton;

    TextView colorSwatch;
    TextView btnSelect;

    public ColorPixer(Context context) {
        super(context);
    }

    public ColorPixer(Context context, DrawActivity d) {
        super(context);
        this.drawColor = d;
    }
    /*
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.color_pixer);
        colorSwatch = (TextView) findViewById(R.id.colorSwatch);
        colorPalette = (ImageView) findViewById(R.id.colorWheel);
        colorPalette.setImageResource(R.drawable.colorwheel);

        btnSelect = (TextView)findViewById(R.id.btn_select);
        btnSelect.setOnClickListener(this);
        colorButton = (Button) findViewById(R.id.btn_select);


        /*
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
*/

        colorPalette.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

                cordinate_x = event.getX();
                cordinate_y = event.getY();

            float [] xy = new float[] {cordinate_x,cordinate_y};
            Matrix matrix = new Matrix();
            ((ImageView)v).getImageMatrix().invert(matrix);

            matrix.mapPoints(xy);
            int x = Integer.valueOf((int)xy[0]);
            int y = Integer.valueOf((int)xy[1]);

            Drawable imgDrawable = ((ImageView)v).getDrawable();
            Bitmap bitmap = ((BitmapDrawable)imgDrawable).getBitmap();
            int bitW = bitmap.getWidth()-1;
            int bitH = bitmap.getHeight()-1;
            if(x < 0){
                x = 0;
            }else if(x > bitW ){
                x = bitW ;
            }

            if(y < 0){
                y = 0;
            }else if(y > bitH ){
                y = bitH ;
            }
            pixel = bitmap.getPixel(x,y);

            //pixel = bitsCanvas.getPixel(cordinate_x,cordinate_y);

                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);


                color = Color.rgb(r,g,b);
                colorSwatch.setBackgroundColor(color);

                btnSelect.setBackgroundColor(color);

            return true;
        }
    });
    }

    public void onClick(View view) {

        if(view.getId() == R.id.btn_select){
            drawColor.setColor(color);
        }
    }



}



