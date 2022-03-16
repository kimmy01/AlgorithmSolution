package com.algo2022_03;

import java.io.*;

public class Main2780 {
    static int m = 1234567;
    static int[][] dp = new int[10][1001];
    static int[] sum = new int[1001];
    static int[][] phone = {
            {7},
            {2, 4},
            {1, 3, 5},
            {2, 6},
            {1, 5, 7},
            {2, 4, 6, 8},
            {3, 5, 9},
            {0, 4, 8},
            {5, 7, 9},
            {6, 8}
    };
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        func();
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(sum[N]);
        }
    }
    static void func(){
        for(int i=1; i<1001; i++){
            for(int j=0; j<10; j++){
                if(i == 1) dp[j][i] = 1;
                else{
                    for(int n : phone[j]){
                        dp[j][i] = (dp[j][i] + dp[n][i-1]) % m;
                    }
                }
                sum[i] = (sum[i] + dp[j][i]) % m;
            }
        }
    }
}
