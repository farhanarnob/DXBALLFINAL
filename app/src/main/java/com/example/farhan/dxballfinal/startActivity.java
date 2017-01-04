package com.example.farhan.dxballfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class StartActivity extends AppCompatActivity {
    Button startButton;
    GameApplication gameApplication;
    EditText column;
    EditText row;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        column = (EditText) findViewById(R.id.column);
        row = (EditText) findViewById(R.id.row);
        startButton = (Button) findViewById(R.id.start);
        gameApplication = (GameApplication) getApplication();
        startButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((Integer.parseInt(column.getText().toString()) > 0 && Integer.parseInt(row.getText().toString()) > 0)) {
                    gameApplication.setColumnRow(Integer.parseInt(column.getText().toString()), Integer.parseInt(row.getText().toString()));
                }

                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                startButton.setText("restart");
                return false;
            }
        });

    }
}
