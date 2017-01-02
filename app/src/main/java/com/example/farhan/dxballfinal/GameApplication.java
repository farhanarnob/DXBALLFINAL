package com.example.farhan.dxballfinal;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameApplication extends Application {
    GamePlayThread gamePlayThread;
    GameBar gameBar;
    BallPosition ballPosition;
    private Paint redBrush;
    private Paint blueBrush;
    private Paint blackBrush;

    @Override
    public void onCreate() {
        super.onCreate();
        redBrush = new Paint();
        redBrush.setColor(Color.RED);
        redBrush.setStyle(Paint.Style.FILL);
        blueBrush = new Paint();
        blueBrush.setColor(Color.BLUE);
        blueBrush.setStyle(Paint.Style.FILL);
        blackBrush = new Paint();
        blackBrush.setColor(Color.BLACK);
        blackBrush.setStyle(Paint.Style.FILL);
    }
    public Paint getRedBrush(){
        return redBrush;
    }

    public Paint getBlueBrush() {
        return blueBrush;
    }

    public Paint getBlackBrush() {
        return blackBrush;
    }

    public GameBar getGameBar() {
        return gameBar;
    }

    public void setGameBar(GameBar gameBar) {
        this.gameBar = gameBar;
    }

    public GamePlayThread getGamePlayThread() {
        return gamePlayThread;
    }

    public void setGamePlayThread(GamePlayThread gamePlayThread) {
        this.gamePlayThread = gamePlayThread;
    }

    public BallPosition getBallPosition() {
        return ballPosition;
    }

    public void setBallPosition(BallPosition ballPosition) {
        this.ballPosition = ballPosition;
    }
}
