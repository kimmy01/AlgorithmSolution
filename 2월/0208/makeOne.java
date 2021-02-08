package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class makeOne {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[]array = new int[n+1];
        array[1] = 0;
        for(int i=2; i<=n; i++){
            array[i] = array[i-1] + 1;
            if(i%3 == 0){
                if(array[i/3]+1 < array[i]){
                    array[i] = array[i/3]+1;
                }
            }
            if(i%2 == 0){
                if(array[i/2]+1 < array[i]){
                    array[i] = array[i/2]+1;
                }
            }
        }
        System.out.println(array[n]);
    }
}
