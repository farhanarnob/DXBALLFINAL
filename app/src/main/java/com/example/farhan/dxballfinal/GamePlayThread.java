package com.example.farhan.dxballfinal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GamePlayThread implements Runnable {
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    GameBar gameBar;
    Canvas gameCanvas;
    BallPosition ballPosition;
    private boolean ballPlay;
    public GamePlayThread(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
        ballPosition = new BallPosition(mainLayout.getContext());

        //game bar
        gameBar = new GameBar(mainLayout.getContext());
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
