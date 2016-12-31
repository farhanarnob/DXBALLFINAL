package com.example.farhan.dxballfinal;

import android.view.SurfaceHolder;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameBar implements Runnable {
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    public GameBar(SurfaceHolder surfaceHolder, MainLayout mainLayout){
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
    }
    @Override
    public void run() {

    }
}
