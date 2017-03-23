package com.dustin_domas_assignment.drawing03;

import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    DrawActivity draw;
    Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar colorSeeker;
        //assignment 03
        //mic check

        draw = new DrawActivity(this);
        draw.setDrawingCacheEnabled(true);
        draw.setBackgroundColor(Color.RED);
        setContentView(draw);

        /*Button play_b = (Button) findViewById(R.id.play_button);
        play_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        DrawActivity.class); //Explicit intent

                startActivity(intent);
            }
        });// end of onclick*/


        }

}


