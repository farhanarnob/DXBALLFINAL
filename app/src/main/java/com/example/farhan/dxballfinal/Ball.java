package com.example.farhan.dxballfinal;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Ball implements Runnable {
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    Canvas ballCanvas;
    BallPosition ballPosition;
    private boolean ballPlay;
    public Ball(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
        ballPosition = new BallPosition(mainLayout.getContext());
    }
    @Override
    public void run() {
        while(ballPlay){
            try{
                ballCanvas = null;
                synchronized (surfaceHolder){
                    ballCanvas = surfaceHolder.lockCanvas();
                    ballPosition.drawBall(ballCanvas);
                }

            }catch (Exception e){
                e.printStackTrace();
            } finally {
                if(ballCanvas!=null){
                    surfaceHolder.unlockCanvasAndPost(ballCanvas);
                }
            }
        }
    }
    public void setRunnable(Boolean ballPlay){
        this.ballPlay = ballPlay;
    }
}
