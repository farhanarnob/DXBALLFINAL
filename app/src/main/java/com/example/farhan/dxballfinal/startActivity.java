package com.example.farhan.dxballfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class StartActivity extends AppCompatActivity {
    Button startButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        startButton = (Button) findViewById(R.id.start);
        startButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });

    }
}
