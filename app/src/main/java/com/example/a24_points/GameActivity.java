package com.example.a24_points;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private String function;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        run();
    }

    public void run() {
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        final TextView calculation = findViewById(R.id.calculation);
        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (function != null ) {
                    function = function + "+";
                    calculation.setText(function);
                } else {
                    calculation.setText("Enter a number first");
                }
            }
        });
        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (function != null ) {
                    function = function + "-";
                    calculation.setText(function);
                } else {
                    calculation.setText("Enter a number first");
                }
            }
        });
        Button multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (function != null ) {
                    function = function + "*";
                    calculation.setText(function);
                } else {
                    calculation.setText("Enter a number first");
                }
            }
        });
        Button divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (function != null ) {
                    function = function + "/";
                    calculation.setText(function);
                } else {
                    calculation.setText("Enter a number first");
                }
            }
        });
        final TextView output = findViewById(R.id.output);
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("Correct!");
            }
        });
    }
}
