package com.algo0318;
import java.io.*;
public class Main_BOJ_15993_123더하기8 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[][] array = new long[2][100001];
        int odd = 0;
        int even = 1;
        array[odd][1] = 1;
        array[even][1] = 0;
        array[odd][2] = 1;
        array[even][2] = 1;
        array[odd][3] = 2;
        array[even][3] = 2;
        for(int i=4; i<=100000; i++){
            array[odd][i] = (array[even][i-1]+array[even][i-2]+array[even][i-3])%1000000009;
            array[even][i] = (array[odd][i-1]+array[odd][i-2]+array[odd][i-3])%1000000009;
        }
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            long aOdd = array[odd][a]%1000000009;
            long aEven = array[even][a]%1000000009;
            sb.append(aOdd+" "+aEven+"\n");
        }
        System.out.println(sb);
    }
}