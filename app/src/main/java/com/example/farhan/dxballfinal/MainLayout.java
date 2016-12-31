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
    public MainLayout(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
