package com.example.a24_points;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private String function = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        run();
    }

    public void run() {
        Button back = findViewById(R.id.back);
        final TextView calculation = findViewById(R.id.calculation);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        final int num1 = (int)(Math.random() * 13) + 1;
        final int num2 = (int)(Math.random() * 13) + 1;
        final int num3 = (int)(Math.random() * 13) + 1;
        final int num4 = (int)(Math.random() * 13) + 1;
        Button one = findViewById(R.id.one);
        one.setText(String.valueOf(num1));
        Button two = findViewById(R.id.two);
        two.setText(String.valueOf(num2));
        Button three = findViewById(R.id.three);
        three.setText(String.valueOf(num3));
        Button four = findViewById(R.id.four);
        four.setText(String.valueOf(num4));
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + num1;
                calculation.setText(function);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + num2;
                calculation.setText(function);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + num3;
                calculation.setText(function);
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + num4;
                calculation.setText(function);
            }
        });
        Button leftHypo = findViewById(R.id.leftHypo);
        leftHypo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + "(";
                calculation.setText(function);
            }
        });
        Button rightHypo = findViewById(R.id.rightHypo);
        rightHypo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                function = function + ")";
                calculation.setText(function);
            }
        });
        Button plus = findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = function + "+";
                calculation.setText(function);
            }
        });
        Button minus = findViewById(R.id.minus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = function + "-";
                calculation.setText(function);
            }
        });
        Button multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = function + "*";
                calculation.setText(function);
            }
        });
        Button divide = findViewById(R.id.divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                function = function + "/";
                calculation.setText(function);
            }
        });
        final TextView output = findViewById(R.id.output);
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal();
            }
        });
    }

    public int cal() {
        return 0;
    }
}
