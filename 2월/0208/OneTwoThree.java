package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OneTwoThree {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            int[] array = new int[12];
            array[1] = 1;
            array[2] = 2;
            array[3] = 4;

            for(int j=4; j<=11; j++){
                array[j] = array[j-1]+array[j-2]+array[j-3];
            }
            System.out.println(array[n]);
        }
    }
}
