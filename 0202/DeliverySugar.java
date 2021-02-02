package com.victoria;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeliverySugar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer=-1;

        int cal = n/3;

        for(int i=0; i<=cal; i++){
            for(int j=0; j<=cal; j++){
                if(3*j+5*i == n){
                    answer = i+j;
                    break;
                }else{
                    continue;
                }
            }
        }
        System.out.println(answer);
    }
}
