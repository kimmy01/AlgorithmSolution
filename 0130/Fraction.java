package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fraction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int X = Integer.parseInt(str);

        int k = 0;
        int i = 1;
        int line = 0;
        int x = 0;
        int y = 0;

        while(true){
            k += i; //한 대각선의 마지막 수
            if(X<=k){
                line = k - X; //뻬거나 더할 값
                if(i%2 == 0){
                    x = i - line;
                    y = 1 + line;
                }else{
                    x = 1 + line;
                    y = i - line;
                }
                break;
            }else{
                i+=1;
            }
        }
        System.out.println(x+"/"+y);
    }
}
