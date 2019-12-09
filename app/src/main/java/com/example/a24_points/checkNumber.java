package com.example.a24_points;
public class checkNumber {
    static int n = 4;
    static int[] number = new int[4];
    static String[] B = new String[4];
    static int count = 0;
    public static void f(int n) {
        if(n == 1)
            if(number[0] == 24) {
                System.out.println(B[0]);
                count++;
            }
            else {
            }
        for(int i = 0;i < n;i++) {
            for(int j = i + 1;j < n;j++) {
                int a,b;
                String x,y;
                a = number[i];
                b = number[j];
                number[j] = number[n-1];
                x = B[i];
                y = B[j];
                B[j] = B[n-1];

                number[i] = a + b;
                B[i] = '(' + x + '+' + y + ')';
                f(n-1);
                number[i] = a - b;
                B[i] = '(' + x + '-' + y + ')';
                f(n-1);
                number[i] = b - a;
                B[i] = '(' + y + '-' + x + ')';
                f(n-1);


                number[i] = a * b;
                B[i] = '(' + x + '*' + y + ')';
                f(n-1);

                if(b!=0) {
                    number[i] = a / b;
                    B[i] = '(' + x + '/' + y + ')';
                    f(n-1);
                }
                if(a!=0) {
                    number[i] = b / a;
                    B[i] = '(' + y + '/' + x + ')';
                    f(n-1);
                }

                number[i] = a;
                number[j] = b;
                B[i] = x;
                B[j] = y;
            }
        }
    }
    public static void getnumber(int a, int b, int c, int d) {
        number[0] = a;
        number[1] = b;
        number[2] = c;
        number[3] = d;
        B[0] = String.valueOf(a);
        B[1] = String.valueOf(b);
        B[2] = String.valueOf(c);
        B[3] = String.valueOf(d);
    }
}