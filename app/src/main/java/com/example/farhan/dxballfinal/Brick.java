package com.example.farhan.dxballfinal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class Brick {

    GameApplication gameApplication;
    float width, height, column, row, padding, allBrickColumn, density, left, top, right, bottom;
    Paint paint;
    public Brick(Context context, int column, int row, int allBrickColumn) {

        gameApplication = (GameApplication) ((Activity) context).getApplication();
        this.column = column;
        this.row = row;
        padding = 1;
        this.allBrickColumn = allBrickColumn;
        density = context.getResources().getDisplayMetrics().density;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
    }

    public void drawBrick(Canvas gameCanvas) {
        width = gameCanvas.getWidth() / allBrickColumn;
        height = (gameCanvas.getHeight() / 2) / 10;

        left = column * width + padding;
        top = row * height + padding;
        right = column * width + width - padding;
        bottom = row * height + height - padding;
        hideBrickCheck();
//        Log.d("Brick","left : "+left+"top: "+top+"right: "+right+"bottom: "+bottom+"column "+column+"row: "+row);
        gameCanvas.drawRoundRect(left, top, right, bottom, 5 * density, 5 * density, paint);
    }

    public void hideBrickCheck() {
        float ballXPosition = gameApplication.getBallPosition().getXBallPosition();
        float ballYPosition = gameApplication.getBallPosition().getYBallPosition();
        float circleRadius = gameApplication.getBallPosition().getCircleRadius();
        if (ballXPosition - circleRadius >= left && ballXPosition + circleRadius <= right) {
            if (ballYPosition <= top + circleRadius) {
                paint.setColor(Color.TRANSPARENT);
                gameApplication.getBallPosition().setEveryUpdateYChange();
            }
        }
    }

}