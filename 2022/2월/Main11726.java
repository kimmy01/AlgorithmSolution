package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11726 {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        int answer = topDown(n);
        System.out.println(answer);
    }
    static int topDown(int n){
        if(n == 0 || n == 1) return 1;
        if(dp[n] > 0) return dp[n];
        dp[n] = topDown(n-2) + topDown(n-1);
        dp[n] %= 10007;
        return dp[n];
    }
}
