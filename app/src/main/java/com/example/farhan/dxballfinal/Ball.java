package com.example.farhan.dxballfinal;

import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Ball implements Runnable {
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    public Ball(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
    }
    @Override
    public void run() {

    }
}
