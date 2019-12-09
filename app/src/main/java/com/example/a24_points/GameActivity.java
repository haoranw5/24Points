package com.example.a24_points;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.Stack;

public class GameActivity extends AppCompatActivity {
    private String function = "";
    private Stack<Integer> numberStack = null;
    private Stack<Character> symbolStack = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        run();
    }
    private int num1 = 0;
    private int num2 = 0;
    private int num3 = 0;
    private int num4 = 0;
    private Boolean numOne = true;
    private Boolean numTwo = true;
    private Boolean numThree = true;
    private Boolean numFour = true;
    public void run() {
        Button back = findViewById(R.id.back);
        final TextView calculation = findViewById(R.id.calculation);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText("");
                function = "";
                numOne = true;
                numTwo = true;
                numThree = true;
                numFour = true;
            }
        });
        setNumber();
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
                if (numOne == true) {
                    function = function + num1;
                    calculation.setText(function);
                    numOne = false;
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numTwo == true) {
                    function = function + num2;
                    calculation.setText(function);
                    numTwo = false;
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numThree == true) {
                    function = function + num3;
                    calculation.setText(function);
                    numThree = false;
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numFour == true) {
                    function = function + num4;
                    calculation.setText(function);
                    numFour = false;
                }
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
        final TextView correctOrNot = findViewById(R.id.correctOrNot);
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numOne == false && numTwo == false && numThree == false && numFour == false) {
                    int i = cal();
                    output.setText(String.valueOf(i));
                    if (check() == true) {
                        correctOrNot.setText("Correct!");
                    } else {
                        correctOrNot.setText("Try Again");
                    }
                }
            }
        });
    }

    public int cal() {
        Expression expression = new Expression(function);
        BigDecimal outPut = expression.eval();
        if (outPut == null) {
            return 0;
        }
        return outPut.intValue();
    }
    private boolean check() {
        if (function == null || function.length() == 0) {
            return false;
        }
        Expression expression = new Expression(function);
        BigDecimal outPut = expression.eval();
        if (outPut == null) {
            return false;
        }
        BigDecimal constant = new BigDecimal(24);
        if (outPut.equals(constant)) {
            return true;
        }
        return false;
    }
    private void setNumber() {
        int a = (int)(Math.random() * 13) + 1;
        int b = (int)(Math.random() * 13) + 1;
        int c = (int)(Math.random() * 13) + 1;
        int d = (int)(Math.random() * 13) + 1;
        checkNumber.getnumber(a, b, c, d);
        checkNumber.f(4);
        if (checkNumber.count != 0) {
            num1 = a;
            num2 = b;
            num3 = c;
            num4 = d;
        } else {
            setNumber();
        }
        System.out.println(checkNumber.count);
    }

}
