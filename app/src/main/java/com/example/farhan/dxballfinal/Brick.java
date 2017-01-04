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
    private int firstHundredMove;
    private boolean collusionCheck;
    public Brick(Context context, int column, int row, int allBrickColumn) {

        gameApplication = (GameApplication) ((Activity) context).getApplication();
        this.column = column;
        this.row = row;
        padding = 1;
        firstHundredMove = 100;
        collusionCheck = false;
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
        if (collusionCheck && (paint.getColor() != Color.TRANSPARENT) && gameApplication.isNoHide() == false) {
            hideBrickCheck();
        } else {
            if (--firstHundredMove < 0) {
                collusionCheck = true;
            }
        }

//        Log.d("Brick","left : "+left+"top: "+top+"right: "+right+"bottom: "+bottom+"column "+column+"row: "+row);
        gameCanvas.drawRoundRect(left, top, right, bottom, 5 * density, 5 * density, paint);
    }

    public void hideBrickCheck() {
        float ballYPosition = gameApplication.getBall().getYBallPosition();
        float ballXPosition = gameApplication.getBall().getXBallPosition();
        float ballCircleRadius = gameApplication.getBall().getCircleRadius();

        if (((ballXPosition + ballCircleRadius) > (left)) && ((ballXPosition - ballCircleRadius) < (right))) {
            if (((ballYPosition - ballCircleRadius) < bottom) && ((ballYPosition + ballCircleRadius) > top)) {
                paint.setColor(Color.TRANSPARENT);
                gameApplication.getBall().setEveryUpdateYChange();
                gameApplication.setNoHide(true);
            }
        }
    }

}