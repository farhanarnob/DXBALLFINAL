package com.example.farhan.dxballfinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    MainLayout mainLayout;
    LinearLayout gameDisplay;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainLayout = new MainLayout(this);
        setContentView(mainLayout);
    }
}
