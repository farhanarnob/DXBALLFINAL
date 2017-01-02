package com.example.farhan.dxballfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GaveOverActivity extends AppCompatActivity {
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        restart = (Button) findViewById(R.id.restart);
        restart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(GaveOverActivity.this, MainActivity.class);
                getApplicationContext().startActivity(intent);
                return true;
            }
        });
    }
}
