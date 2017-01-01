package com.example.farhan.dxballfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MainLayout mainLayout;
    LinearLayout gameDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainLayout = new MainLayout(this);
        setContentView(R.layout.activity_main);
        gameDisplay = (LinearLayout) findViewById(R.id.app_display_of_the_game);
        gameDisplay.addView(mainLayout);
        gameDisplay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mainLayout.setGameBarPosition(motionEvent.getX());
                return false;
            }
        });
    }
}
