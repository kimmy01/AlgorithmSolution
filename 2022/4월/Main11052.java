package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main11052 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.max(dp[i], arr[j]+dp[i-j]);
            }
        }
        System.out.println(dp[N]);
    }
}
