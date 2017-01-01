package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;


/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GamePlayThread implements Runnable {
    GameBar gameBar;
    Brick brick[];
    Canvas gameCanvas;
    BallPosition ballPosition;
    float brickXPosition, brickYPosition;
    GameApplication gameApplication;
    int rowCount, columnCount, allBrickColumn, brickCount;
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    private boolean ballPlay;


    public GamePlayThread(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
        ballPosition = new BallPosition(mainLayout.getContext());
        brickCount = 0;
        columnCount = 5;
        rowCount = 5;
        allBrickColumn = columnCount * rowCount;
        gameApplication = (GameApplication) ((Activity) mainLayout.getContext()).getApplication();
        brick = new Brick[allBrickColumn];
        //game bar
        gameBar = new GameBar(mainLayout.getContext());

        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                brick[brickCount] = new Brick(mainLayout.getContext(), i, j, columnCount);
                brickCount++;
            }

        }
    }
    @Override
    public void run() {
        while(ballPlay){
            try{
                gameCanvas = null;
                synchronized (surfaceHolder){
                    gameCanvas = surfaceHolder.lockCanvas();
                    gameCanvas.drawColor(Color.WHITE);
                    ballPosition.drawBall(gameCanvas);
                    for (int i = 0; i < brickCount; i++) {
                        brick[i].drawBrick(gameCanvas);
                    }
                    gameBar.drawBar(gameCanvas);
                }

            }catch (Exception e){
                e.printStackTrace();
            } finally {
                if(gameCanvas!=null){
                    surfaceHolder.unlockCanvasAndPost(gameCanvas);
                }
            }
        }
    }
    public void setRunnable(Boolean ballPlay){
        this.ballPlay = ballPlay;
    }
}
