package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class MainLayout extends SurfaceView implements SurfaceHolder.Callback {

    GamePlayThread gamePlayThread;
    GameApplication gameApplication;
    GameBar gameBar;
    Thread gamePlayThreadHolder;

    public MainLayout(Context context) {
        super(context);
        getHolder().addCallback(this);
        getHolder().setFormat(PixelFormat.TRANSLUCENT);
        // initialization
        gameApplication = (GameApplication) ((Activity) context).getApplication();
        gameBar = new GameBar(getContext());
        // game thread for ball
        gamePlayThread = new GamePlayThread(getHolder(), this);
        gamePlayThreadHolder = new Thread(gamePlayThread);

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        gamePlayThread.setRunnable(true);
        gamePlayThreadHolder.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Boolean destroyBall = true;
        gamePlayThread.setRunnable(false);
        while (destroyBall) {
            try {
                gamePlayThreadHolder.join();
                destroyBall = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setGameBarPosition(float x) {
        gameBar.changeOnTouch(x);
    }
}
