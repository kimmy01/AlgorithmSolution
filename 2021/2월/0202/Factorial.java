package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Function(N);
    }
    static int answer = 1;
    static void Function(int n){
        if(n == 0){
            System.out.println(answer);
            return;
        }else{
            answer*=n;
            n--;
        }
        Function(n);
    }
}
