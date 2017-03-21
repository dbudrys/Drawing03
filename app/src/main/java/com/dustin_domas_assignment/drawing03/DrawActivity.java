package com.dustin_domas_assignment.drawing03;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Paint;
import org.w3c.dom.Attr;

public class DrawActivity extends View {

    private Paint paint;


    public DrawActivity(Context context){
     super(context);
        setUp(null);
 }

    public DrawActivity(Context context, AttributeSet attr){
        super(context, attr);
        setUp(attr);
    }

    public DrawActivity(Context context, AttributeSet attr, int defStyleAttr){
        super(context, attr, defStyleAttr);
        setUp(attr);
    }
@Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

    }

    private void setUp(AttributeSet attr){

    }

}
