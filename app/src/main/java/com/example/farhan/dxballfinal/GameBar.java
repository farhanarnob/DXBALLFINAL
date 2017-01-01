package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameBar implements View.OnTouchListener{

    boolean firstTime=true;
    GameApplication gameApplication;
    float barXPosition,barYPosition,density;
    public GameBar(Context context){
        density = context.getResources().getDisplayMetrics().density;
        gameApplication = (GameApplication)((Activity) context).getApplication();
    }

    public void drawBar(Canvas gameCanvas) {
        if(firstTime){
            barXPosition = gameCanvas.getWidth()/2;
            barYPosition = gameCanvas.getHeight()-20*density;
            firstTime = false;
        }
        gameCanvas.drawRect(barXPosition-50*density,barYPosition+10*density,barXPosition+50*density,barYPosition-10*density,gameApplication.getRedBrush());
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
