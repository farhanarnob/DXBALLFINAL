package com.example.farhan.dxballfinal;

import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Brick implements Runnable {
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    public Brick(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
    }
    @Override
    public void run() {

    }
}
