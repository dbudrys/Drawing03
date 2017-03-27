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
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    DrawActivity draw;
    Paint mPaint;
    Button play;
    Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorSeeker colorSeeker;
        //assignment 03
        //mic check
        //toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        draw = new DrawActivity(this);
        draw.setDrawingCacheEnabled(true);
        //draw.setBackgroundColor(Color.RED);

        fab = (FloatingActionButton) findViewById(R.id.fabButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPixer colorDialog = new ColorPixer(MainActivity.this);
                colorDialog.show();
            }
        });
        play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(draw);
            }


        });







        //colorSeeker = new (ColorSeeker) findViewById(R.id.colorSeek);


        }

    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);


        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu){
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){


        return true;
    }

}


