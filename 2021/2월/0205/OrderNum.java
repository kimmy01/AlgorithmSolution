package com.victoria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OrderNum {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];

        for(int i=0; i<N; i++){
            number[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=0; j<N; j++){
                if(number[i] > number[j]){
                    temp = number[j];
                    number[j] = number[i];
                    number[i] = temp;
                }
            }
        }

        for(int i=N-1 ;i>=0; i--){
            bw.write(String.valueOf(number[i]));
            bw.newLine();
        }
        bw.flush();
    }
}
