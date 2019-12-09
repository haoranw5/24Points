package com.example.a24_points;


import java.util.Random;

public class checkNumber {
    static int n = 4;//运算次数标记
    static int[] A = new int[4];//存放四个数字
    static String[] B = new String[4];//存放字符串型的四个数字，也存放表达式
    static int count = 0;//计数
    public static void f(int n) {
        //判断是否已完成三次运算
        if(n == 1)
            if(A[0] == 24) {//A[0]里面存放的最后的结果
                System.out.println(B[0]);//B[0]存放的结果表达式
                count++;
            }
            else {//空的不做处理进行下一条语句

            }
        //从数组中任意取出俩个数的组合
        for(int i = 0;i < n;i++) {
            for(int j = i + 1;j < n;j++) {
                int a,b;
                String x,y;
                a = A[i];
                b = A[j];
                A[j] = A[n-1];//将最后一位的数字放入下标为j的位置（也就是空出来的那个位置，相当于空出来，）
                x = B[i];
                y = B[j];
                B[j] = B[n-1];//与上面同理

                A[i] = a + b;//第一个空间保存运算的结果
                B[i] = '(' + x + '+' + y + ')';//将第一步运算的表达式放在字符串数组中
                f(n-1);

                //减法需要区分顺序
                A[i] = a - b;
                B[i] = '(' + x + '-' + y + ')';
                f(n-1);
                A[i] = b - a;
                B[i] = '(' + y + '-' + x + ')';
                f(n-1);

                //乘法
                A[i] = a * b;
                B[i] = '(' + x + '*' + y + ')';
                f(n-1);

                //除法和减法一样需区分顺序这里要处理除数为0的情况，因为计算过程中可能出现除数为0的情况
                if(b!=0) {
                    A[i] = a / b;
                    B[i] = '(' + x + '/' + y + ')';
                    f(n-1);
                }
                if(a!=0) {
                    A[i] = b / a;
                    B[i] = '(' + y + '/' + x + ')';
                    f(n-1);
                }
                //当上面四则运算都不满足时
                //为了方便进入下一个for循环, 需要将之前的i和j上的值都重新找回
                A[i] = a;
                A[j] = b;
                B[i] = x;
                B[j] = y;
            }
        }
        System.out.println(count);
    }
    public static void getnumber(int a, int b, int c, int d) {
        A[0] = a;
        A[1] = b;
        A[2] = c;
        A[3] = d;
        B[0] = String.valueOf(a);
        B[1] = String.valueOf(b);
        B[2] = String.valueOf(c);
        B[3] = String.valueOf(d);
    }
}