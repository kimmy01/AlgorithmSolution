package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N+1];
            int[][] dp = new int[2][N+1];
            for(int i=0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int k=2; k<=N; k++){
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2])+arr[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2])+arr[1][k];
            }
            System.out.println(Math.max(dp[0][N], dp[1][N]));
        }
    }
}
