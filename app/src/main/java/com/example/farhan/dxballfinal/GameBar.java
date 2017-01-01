package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameBar {

    private boolean firstTime = true;
    private GameApplication gameApplication;
    private float barXPosition, barYPosition, density;
    private float latestX;
    public GameBar(Context context){
        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
    }

    public void drawBar(Canvas gameCanvas) {
        if(firstTime){
            latestX = 0;
            barXPosition = gameCanvas.getWidth()/2;
            barYPosition = gameCanvas.getHeight()-20*density;
            firstTime = false;
        }
        getLatestXBarPosition();
        float left = barXPosition - 70 * density;
        float top = barYPosition + 10 * density;
        float right = barXPosition + 70 * density;
        float bottom = barYPosition - 10 * density;
        gameCanvas.drawRect(left, top, right, bottom, gameApplication.getBlackBrush());

    }

    public void changeOnTouch(float x) {
        latestX = x;
    }

    public void getLatestXBarPosition() {
        if (latestX != 0) {
            barXPosition = latestX;
        }
    }
}
