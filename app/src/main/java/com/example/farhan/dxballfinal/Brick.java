package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Brick {

    GameApplication gameApplication;
    float width, height, column, row, padding, allBrickColumn, density;

    public Brick(Context context, int column, int row, int allBrickColumn) {
        gameApplication = (GameApplication) ((Activity) context).getApplication();
        this.column = column;
        this.row = row;
        padding = 1;
        this.allBrickColumn = allBrickColumn;
        density = context.getResources().getDisplayMetrics().density;
    }

    public void drawBrick(Canvas gameCanvas) {
        width = gameCanvas.getWidth() / allBrickColumn;
        height = (gameCanvas.getHeight() / 2) / 10;

        float left = column * width + padding;
        float top = row * height + padding;
        float right = column * width + width - padding;
        float bottom = row * height + height - padding;
//        Log.d("Brick","left : "+left+"top: "+top+"right: "+right+"bottom: "+bottom+"column "+column+"row: "+row);
        gameCanvas.drawRoundRect(left, top, right, bottom, 5 * density, 5 * density, gameApplication.getBlueBrush());
    }

}