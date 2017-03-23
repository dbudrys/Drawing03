package com.dustin_domas_assignment.drawing03;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.SeekBar;

/**
 * Created by dustinlobato on 3/20/17.
 */

public class ColorSeeker extends SeekBar implements SeekBar.OnSeekBarChangeListener {

    float size;
    int color;
    Paint painter;

   private OnColorSeekListener nOnColorPickerListener;

    public void setOnColorSeekListener(OnColorSeekListener listener) {
        this.nOnColorPickerListener = listener;
    }

    public ColorSeeker(Context context) {
        super(context);
        setOnSeekBarChangeListener(this);
    }

    public ColorSeeker(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnSeekBarChangeListener(this);
    }

    public ColorSeeker(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnSeekBarChangeListener(this);
    }


@Override
    public void onSizeChanged(int w, int h, int oldW, int oldH){

        super.onSizeChanged(w,h,oldW,oldH);



    }

    public interface OnColorSeekListener {
        void onColorChanged(SeekBar bar, int color, boolean b);

        void onStartTrackingTouch(SeekBar bar);

        void onStopTrackingTouch(SeekBar bar);

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red,blue,green;



    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }





}





