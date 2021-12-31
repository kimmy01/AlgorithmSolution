package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Function(N);
    }

    static int num0 = 0;
    static int num1 = 1;
    static int num2;
    static int count = 1;
    static void Function(int n){
        if(n == 0) {System.out.println(0);return;}
        if(n == 1) {System.out.println(1);return;}
        if(count == n){
            System.out.println(num2);
            return;
        }else{
            num2 = num0 + num1;
            num0 = num1;
            num1 = num2;
            count++;
        }
        Function(n);
    }
}
