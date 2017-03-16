package com.dustin_domas_assignment.drawing03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assignment 03
        //mic check

        Button play_b = (Button) findViewById(R.id.play_button);
        play_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        DrawActivity.class); //Explicit intent

                startActivity(intent);
            }
        });// end of onclick


    }
}
