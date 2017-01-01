package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;


/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class BallPosition {
    GameApplication gameApplication;
    float xBallPosition, yBallPosition, circleRadius, everyUpdateXChange, everyUpdateYChange, displayWidth, displayHeight, radius, density;
    boolean firstTime = true;
    public BallPosition(Context context){
        xBallPosition=250; yBallPosition=250;
        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
        radius = 30 * density;
        everyUpdateXChange = 5 * density;
        everyUpdateYChange = 5 * density;
        circleRadius = 20*density;
    }
    public void drawBall(Canvas canvas){
        if(firstTime){
            displayWidth = canvas.getWidth();
            displayHeight = canvas.getHeight();
            firstTime = false;
        }
        motionCircle();
        canvas.drawCircle(xBallPosition,yBallPosition,circleRadius,gameApplication.getRedBrush());
    }
    private void motionCircle(){
        if(xBallPosition >= (displayWidth-radius)){
            everyUpdateXChange=-everyUpdateXChange;
        }
        else if(xBallPosition<=radius){
            everyUpdateXChange=-everyUpdateXChange;
        }
        else if(yBallPosition>=(displayHeight-radius)){
            everyUpdateYChange=-everyUpdateYChange;
        }
        else if(yBallPosition<=radius){
            everyUpdateYChange=-everyUpdateYChange;
        }
        xBallPosition += everyUpdateXChange;
        yBallPosition += everyUpdateYChange;
    }
}