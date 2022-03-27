package com.algo2022_03;

import java.io.*;

public class Main9625 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[46][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        for(int i=1; i<=45; i++){
            int lastA = dp[i-1][0];
            int lastB = dp[i-1][1];
            dp[i][0] = lastB;
            dp[i][1] = lastA+lastB;
        }
        System.out.println(dp[K][0]+" "+dp[K][1]);
    }
}
