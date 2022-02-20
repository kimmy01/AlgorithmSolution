package com.algo2022_02;

import java.io.*;

public class Main8393{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i=1; i<=N; i++){
            sum += i;
        }
        System.out.println(sum);
    }
}