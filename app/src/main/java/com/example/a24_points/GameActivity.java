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
        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });
        Button clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculation.setText("");
                function = "";
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
        final TextView correctOrNot = findViewById(R.id.correctOrNot);
        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = cal(function);
                output.setText(String.valueOf(i));
                if (check() == true) {
                    correctOrNot.setText("Correct!");
                } else {
                    correctOrNot.setText("Try Again");
                }
            }
        });
    }

    public int cal(String numStr) {
        numberStack = new Stack<Integer>();
        symbolStack = new Stack<Character>();
        StringBuffer temp = new StringBuffer();
        if (numStr.length() > 1 && !"=".equals(numStr.charAt(numStr.length() - 1) + "")) {
            numStr += "=";
        }
        for (int i = 0; i < numStr.length(); i++) {
            char ch = numStr.charAt(i);
            if (isNumber(ch)) {
                temp.append(ch);
                } else {
                    String tempStr = temp.toString();
                    if (!tempStr.isEmpty()) {
                    int num = Integer.parseInt(tempStr);
                    numberStack.push(num);
                    temp = new StringBuffer();
                    }
                    while (!comparePri(ch) && !symbolStack.empty()) {
                        int b = numberStack.pop();
                        int a = numberStack.pop();
                        switch ((char) symbolStack.pop()) {
                            case '+':
                                numberStack.push(a + b);
                                break;
                            case '-':
                                numberStack.push(a - b);
                                break;
                            case '*':
                                numberStack.push(a * b);
                                break;
                            case '/':
                                numberStack.push(a / b);
                                break;
                            default:
                                break;
                            }
                    }
                    if (ch != '=') {
                        symbolStack.push(new Character(ch));
                    }
                    if (ch == ')') {
                        symbolStack.pop();
                        symbolStack.pop();
                    }
                }
            }
        return numberStack.pop();
    }

    private boolean isNumber(char num) {
        if (num >= '0' && num <= '9') {
            return true;
        }
        return false;
    }

    private boolean comparePri(char symbol) {
        if (symbolStack.empty()) {
            return true;
        }
        char top = (char) symbolStack.peek();
        if (top == '(') {
            return true;
        }
        switch (symbol) {
            case '(':
                return true;
            case '*': {
                if (top == '+' || top == '-') {
                    return true;
                } else {
                    return false;
                }
            }
            case '/': {
                if (top == '+' || top == '-') {
                    return true;
                } else {
                    return false;
                }
            }
            case '+':
                return false;
            case '-':
                return false;
            case ')':
                return false;
            case '=':
                return false;
            default:
                break;
        }
        return true;
    }
    private boolean check() {
        if (function == null || function.length() == 0) {
            return false;
        }
        Expression expression = new Expression(function);
        BigDecimal outPut = expression.eval();
        BigDecimal constant = new BigDecimal(24);
        if (outPut.equals(constant)) {
            return true;
        }
        return false;
    }
}
