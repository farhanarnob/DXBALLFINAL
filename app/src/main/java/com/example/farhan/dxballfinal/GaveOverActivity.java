package com.example.farhan.dxballfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.farhan.dxballfinal.R.id.column_game_over;
import static com.example.farhan.dxballfinal.R.id.row_game_over;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class GaveOverActivity extends AppCompatActivity {
    GameApplication gameApplication;
    EditText column;
    EditText row;
    Button restartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        column = (EditText) findViewById(column_game_over);
        row = (EditText) findViewById(row_game_over);
        restartButton = (Button) findViewById(R.id.restart_buttton);
        gameApplication = (GameApplication) getApplication();
        restartButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((Integer.parseInt(column.getText().toString()) > 0 && Integer.parseInt(row.getText().toString()) > 0)) {
                    gameApplication.setColumnRow(Integer.parseInt(column.getText().toString()), Integer.parseInt(row.getText().toString()));
                }

                Intent intent = new Intent(GaveOverActivity.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
}
