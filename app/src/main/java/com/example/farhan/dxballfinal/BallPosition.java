package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.Log;


/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class BallPosition {
    boolean firstTime = true;
    private GameApplication gameApplication;
    private float xBallPosition, yBallPosition, circleRadius, everyUpdateXChange, everyUpdateYChange, displayWidth, displayHeight, density;
    private Context context;
    public BallPosition(Context context){
        this.context = context;
        xBallPosition = 250;
        yBallPosition = 650;
        gameApplication = (GameApplication)((Activity) context).getApplication();
        density = context.getResources().getDisplayMetrics().density;
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
        checkBarCollusion();

        motionCircle();
        canvas.drawCircle(xBallPosition,yBallPosition,circleRadius,gameApplication.getRedBrush());
    }
    private void motionCircle(){
        if (xBallPosition >= (displayWidth - circleRadius)) {
            everyUpdateXChange=-everyUpdateXChange;
        }
        if (xBallPosition <= circleRadius) {
            everyUpdateXChange=-everyUpdateXChange;
        }
        if (yBallPosition >= (displayHeight - circleRadius)) {
            gameApplication.getGamePlayThread().setRunnable(false);
            checkGameOver();
        }
        if (yBallPosition <= circleRadius) {
            everyUpdateYChange=-everyUpdateYChange;
        }
        xBallPosition += everyUpdateXChange;
        yBallPosition += everyUpdateYChange;
    }

    private void checkGameOver() {
        Intent intent = new Intent(context, GaveOverActivity.class);
        context.startActivity(intent);
    }

    private void checkBarCollusion() {
        GameBar gameBar = gameApplication.getGameBar();
        Log.d("BallPosition", "left: " + gameBar.getLeft() + "right: " + gameBar.getRight() + "bottom: " + gameBar.getBottom() + "xBall: " + xBallPosition + " yBall : " + yBallPosition);
        if (xBallPosition >= gameBar.getLeft() && xBallPosition <= gameBar.getRight()) {
            if (yBallPosition + circleRadius >= gameBar.getBottom()) {
                everyUpdateYChange = -everyUpdateYChange;
                xBallPosition += everyUpdateXChange;
                yBallPosition += everyUpdateYChange;
            }
        }

    }

    public float getXBallPosition() {
        return xBallPosition;
    }

    public float getYBallPosition() {
        return yBallPosition;
    }

    public float getCircleRadius() {
        return circleRadius;
    }

    public void setEveryUpdateYChange() {
        everyUpdateYChange -= everyUpdateYChange;
        yBallPosition -= everyUpdateYChange;
    }
}