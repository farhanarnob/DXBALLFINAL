package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;


/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GamePlayThread extends Thread {
    private GameBar gameBar;
    private Brick brick[];
    private Canvas gameCanvas;
    private Ball ball;
    private GameApplication gameApplication;
    private int rowCount, columnCount, allBrickColumn, brickCount;
    private SurfaceHolder surfaceHolder;
    private MainLayout mainLayout;
    private boolean ballPlay;


    public GamePlayThread(SurfaceHolder surfaceHolder, final MainLayout mainLayout) {
        this.surfaceHolder = surfaceHolder;
        this.mainLayout = mainLayout;
        ball = new Ball(mainLayout.getContext());
        brickCount = 0;
        columnCount = 2;
        rowCount = 1;
        allBrickColumn = columnCount * rowCount;
        gameApplication = (GameApplication) ((Activity) mainLayout.getContext()).getApplication();
        brick = new Brick[allBrickColumn];
        //game bar
        gameBar = new GameBar(mainLayout.getContext());
        gameApplication.setGameBar(gameBar);
        gameApplication.setBall(ball);
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_MOVE == motionEvent.getAction()) {
                    gameBar.changeOnTouch(motionEvent.getX());
                }
                return true;
            }
        });
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                brick[brickCount] = new Brick(mainLayout.getContext(), i, j, columnCount);
                brickCount++;
            }
        }
        gameApplication.setAllBrickColumn(allBrickColumn);
    }
    @Override
    public void run() {
        while(ballPlay){
            synchronized (surfaceHolder) {
                try {
                    gameCanvas = null;

                    gameCanvas = surfaceHolder.lockCanvas();
                    gameCanvas.drawColor(Color.WHITE);
                    for (int i = 0; i < brickCount; i++) {
                        brick[i].drawBrick(gameCanvas);
                    }
                    ball.drawBall(gameCanvas);
                    gameBar.drawBar(gameCanvas);
                    gameApplication.setNoHide(false);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (gameCanvas != null) {
                        surfaceHolder.unlockCanvasAndPost(gameCanvas);
                    }
                }
            }

        }
    }
    public void setRunnable(Boolean ballPlay){
        this.ballPlay = ballPlay;
    }
}
