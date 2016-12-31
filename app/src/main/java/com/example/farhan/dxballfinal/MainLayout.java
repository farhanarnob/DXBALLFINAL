package com.example.farhan.dxballfinal;

import android.content.Context;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class MainLayout extends SurfaceView implements SurfaceHolder.Callback {
    GameBar gameBar;
    Ball ball;
    Brick brick;
    Thread gameBarThread;
    Thread brickThread;
    Thread ballThread;
    public MainLayout(Context context) {
        super(context);
        getHolder().addCallback(this);
        ball = new Ball(getHolder(),this);
        ballThread = new Thread(ball);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ball.setRunnable(true);
        ballThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Boolean destroyBall=true;
        ball.setRunnable(false);
        while (destroyBall){
            try {
                ballThread.join();
                destroyBall = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
