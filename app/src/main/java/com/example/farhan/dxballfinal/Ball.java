package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.util.Log;


/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Ball {
    private boolean firstTime = true;
    private GameApplication gameApplication;
    private float xBallPosition, yBallPosition, circleRadius, everyUpdateXChange, everyUpdateYChange, displayWidth, displayHeight, density;
    private Context context;

    public Ball(Context context) {
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
        if (yBallPosition >= (displayHeight - circleRadius - 14 * density)) {
            gameApplication.getGamePlayThread().setRunnable(false);
            checkGameOver();
        }
        if (yBallPosition <= circleRadius) {
            everyUpdateYChange=-everyUpdateYChange;
        }
        xBallPosition += everyUpdateXChange;
        yBallPosition += everyUpdateYChange;
    }

    public void checkGameOver() {
        Intent intent = new Intent(context, StartActivity.class);
        context.startActivity(intent);
    }

    private void checkBarCollusion() {
        GameBar gameBar = gameApplication.getGameBar();
        Log.d("Ball", "left: " + gameBar.getLeft() + "right: " + gameBar.getRight() + "bottom: " + gameBar.getBottom() + "xBall: " + xBallPosition + " yBall : " + yBallPosition);
        float barMiddlePosition = (gameBar.getRight() + gameBar.getLeft()) / 2;
        if (xBallPosition >= gameBar.getLeft() && xBallPosition <= gameBar.getRight()) {
            if (yBallPosition + circleRadius >= gameBar.getBottom()) {
                everyUpdateYChange = -everyUpdateYChange;
                if ((xBallPosition - barMiddlePosition) > 40 || (barMiddlePosition - xBallPosition) > 40) {
                    if (barMiddlePosition > xBallPosition && everyUpdateXChange < 14) {
                        everyUpdateXChange = everyUpdateXChange + barMiddlePosition / xBallPosition * 7;
                    }
                    if (barMiddlePosition < xBallPosition && everyUpdateXChange > -14) {
                        everyUpdateXChange = everyUpdateXChange - barMiddlePosition / xBallPosition * 7;
                    }
                }
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
        everyUpdateYChange = -everyUpdateYChange;
    }

    public void setEveryUpdateXChange() {
        everyUpdateXChange = -everyUpdateXChange;
    }
}