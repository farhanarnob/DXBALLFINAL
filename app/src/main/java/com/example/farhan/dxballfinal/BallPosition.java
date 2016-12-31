package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class BallPosition {
    float xBallStart, yBallStart, circleRadius;
    GameApplication gameApplication;
    float density ;
    public BallPosition(Context context){

        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
        circleRadius = 5*density;

    }
    public void drawBall(Canvas canvas){
        canvas.drawCircle(50,50,circleRadius,gameApplication.getRedBrush());
    }
}
