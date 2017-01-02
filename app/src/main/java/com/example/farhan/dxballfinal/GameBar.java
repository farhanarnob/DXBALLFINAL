package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameBar {

    private float left = 89, top, right, bottom;
    private boolean firstTime = true;
    private GameApplication gameApplication;
    private float barXPosition, barYPosition, density;
    private float widthOfCanvas;

    public GameBar(Context context){
        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
        widthOfCanvas = context.getResources().getDisplayMetrics().widthPixels;
        Log.d("GameBar", "width: " + widthOfCanvas);
    }

    public void drawBar(Canvas gameCanvas) {
        if(firstTime){
            barXPosition = gameCanvas.getWidth()/2;
            barYPosition = gameCanvas.getHeight()-20*density;
            firstTime = false;
        }
        left = barXPosition - 70 * density;
        top = barYPosition + 10 * density;
        right = barXPosition + 70 * density;
        bottom = barYPosition - 10 * density;
        gameCanvas.drawRect(left, top, right, bottom, gameApplication.getBlackBrush());
    }

    public void changeOnTouch(float x) {
        if ((x - 70 * density) > 0 && x + 70 * density < widthOfCanvas) {
            barXPosition = x;
        }
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }
}
