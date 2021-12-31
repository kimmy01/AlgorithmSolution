package com.algo0322;
import java.io.*;
public class Main_BOJ_9461_파도반수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for(int i=5; i<=100; i++){
            dp[i] = dp[i-3] + dp[i-2];
        }
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }
}