package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class BallPosition {
    float xBallStart, yBallStart, circleRadius;
    GameApplication gameApplication;
    float density, everyUpdateChange ;
    public BallPosition(Context context){
        xBallStart=50; yBallStart=50;
        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
        everyUpdateChange = 3*density;
        circleRadius = 20*density;
    }
    public void drawBall(Canvas canvas){
        xBallStart += everyUpdateChange;
        yBallStart += everyUpdateChange;
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(xBallStart,yBallStart,circleRadius,gameApplication.getRedBrush());
    }
}
