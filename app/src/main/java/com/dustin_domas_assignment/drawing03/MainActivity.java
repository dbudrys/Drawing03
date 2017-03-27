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

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    DrawActivity draw;
    Paint mPaint;
    Button play;
   int nColor;
    FloatingActionButton paintColor;
    FloatingActionButton brushSize;
    FloatingActionButton erase;
    FloatingActionButton newButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        draw = new DrawActivity(this);
        draw.setDrawingCacheEnabled(true);


        paintColor = (FloatingActionButton) findViewById(R.id.fabButton);

        brushSize = (FloatingActionButton) findViewById(R.id.brushFab);

        paintColor.setOnClickListener(this);
        brushSize.setOnClickListener(this);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorPixer colorDialog = new ColorPixer(MainActivity.this);
                colorDialog.show();
            }
        });*/


       play = (Button) findViewById(R.id.play_button);
        play.setOnClickListener(this);
       /*  play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(draw);
            }


        });*/





        }


        public void onClick(View view){

            if(view.getId()==R.id.fabButton){
                ColorPixer colorDialog = new ColorPixer(MainActivity.this);


                colorDialog.show();

                draw.setColor(nColor);
            }

            if(view.getId() == R.id.play_button){
                setContentView(draw);
            }
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


