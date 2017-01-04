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
    Ball ball;
    private int row = 3, column = 8;
    private Paint redBrush;
    private Paint blueBrush;
    private Paint blackBrush;
    private boolean noHide;
    private int count = 0;
    private int allBrickColumn;
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
        noHide = false;
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

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public boolean isNoHide() {
        return noHide;
    }

    public void setNoHide(boolean noHide) {
        this.noHide = noHide;
    }

    public void BrickCount() {
        ++count;
        if (count >= allBrickColumn) {
            ball.checkGameOver();
        }
    }

    public void setAllBrickColumn(int allBrickColumn) {
        this.allBrickColumn = allBrickColumn;
    }


    public void setColumnRow(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
