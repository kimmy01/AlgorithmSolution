package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hansoo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int test = Integer.parseInt(N);
        int count = 0;

        int a = 0;
        int b = 0;
        int c = 0;
        int temp = 0;

        if(test<100){
            count = test;
        }else if(100 <= test && test<1000){
            for(int i = 100; i <= test; i++){
                temp = i;
                a = temp/100;
                temp = temp%100;
                b = temp/10;
                c = temp%10;

                if(a - b == b - c){
                    count++;
                }
                temp = i;
            }
            count+=99;
        }else{
            count = 144;
        }
        System.out.println(count);
    }
}
