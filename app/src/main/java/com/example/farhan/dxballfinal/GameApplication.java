package com.example.farhan.dxballfinal;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameApplication extends Application {
    private Paint redBrush;
    private Paint blueBrush;
    private Paint blackBrush;
    @Override
    public void onCreate() {
        super.onCreate();
        redBrush = new Paint();
        redBrush.setColor(Color.RED);
        redBrush.setStyle(Paint.Style.FILL);
        blueBrush = new Paint();
        blueBrush.setColor(Color.BLUE);
        blueBrush.setStyle(Paint.Style.FILL);
        blackBrush = new Paint();
        blackBrush.setColor(Color.BLACK);
        blackBrush.setStyle(Paint.Style.FILL);
    }
    public Paint getRedBrush(){
        return redBrush;
    }

    public Paint getBlueBrush() {
        return blueBrush;
    }

    public Paint getBlackBrush() {
        return blackBrush;
    }
}
