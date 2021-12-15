package com.example.drawingApp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button blackInk;
    private Button cyanInk;
    private Button purpleInk;
    private Button add;
    private Button subtract;
    private int inkSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackInk = findViewById(R.id.btnBlack);
        cyanInk = findViewById(R.id.btnCyan);
        purpleInk = findViewById(R.id.btnPurple);
        add = findViewById(R.id.btnMinus);
        subtract = findViewById(R.id.btnPlus);
        inkSize = 10;
    }


    //****************************************************COLOR OPTIONS********************************************************************************//
    // Make the buttons for the packable colors visible
    public void onClickColor(android.view.View view){
        if(blackInk.getVisibility() == View.INVISIBLE){
            blackInk.setVisibility(View.VISIBLE);
            cyanInk.setVisibility(View.VISIBLE);
            purpleInk.setVisibility(View.VISIBLE);
        }
        else{
            blackInk.setVisibility(View.INVISIBLE);
            cyanInk.setVisibility(View.INVISIBLE);
            purpleInk.setVisibility(View.INVISIBLE);
        }
    }

    // Control for making the ink Color black
    public void onClickBlack(android.view.View view){
        DrawingAppView.getInk().setColor(Color.BLACK);
    }

    // Control for making the ink Color cyan
    public void onClickCyan(android.view.View view){
        DrawingAppView.getInk().setColor(Color.CYAN);
    }

    // Control for making the ink Color purple. Purple didn't exist in Color so this color looks different because I took it from the colors.xml file.
    @SuppressLint("ResourceAsColor")
    public void onClickPurple(android.view.View view){
        DrawingAppView.getInk().setColor(R.color.purple_200);
    }

    //****************************************************SIZE OPTIONS********************************************************************************//
    // Make the buttons for the packable sizes visible
    public void onClickSize(android.view.View view){
        if(add.getVisibility() == View.INVISIBLE){
            add.setVisibility(View.VISIBLE);
            subtract.setVisibility(View.VISIBLE);
        }
        else{
            add.setVisibility(View.INVISIBLE);
            subtract.setVisibility(View.INVISIBLE);
        }
    }

    // Control for making the inkSize bigger
    public void onClickPlus(android.view.View view){
        if(inkSize < 50){
            inkSize += 5;
        }
        else{
            inkSize = 50;
        }
        DrawingAppView.getInk().setStrokeWidth(inkSize);
    }

    // Control for making the inkSize smaller
    public void onClickMinus(android.view.View view){
        if(inkSize > 5){
            inkSize -= 5;
        }
        else{
            inkSize = 5;
        }
        DrawingAppView.getInk().setStrokeWidth(inkSize);
    }
}