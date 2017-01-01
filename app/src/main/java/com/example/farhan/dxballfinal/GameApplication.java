package com.example.farhan.dxballfinal;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GameApplication extends Application {
    private Paint redBrush;

    @Override
    public void onCreate() {
        super.onCreate();
        redBrush = new Paint();
        redBrush.setColor(Color.RED);
        redBrush.setStyle(Paint.Style.FILL);
    }
    public Paint getRedBrush(){
        return redBrush;
    }
}
