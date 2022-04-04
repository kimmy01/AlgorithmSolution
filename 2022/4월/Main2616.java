package com.algo2022_04;

import java.util.*;
import java.io.*;

public class Main2616 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] train = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            int n = Integer.parseInt(st.nextToken());
            train[i] = train[i-1] + n;
        }
        int M = Integer.parseInt(br.readLine());
        int[][] dp = new int[4][N+1];
        for(int i=1; i<=3; i++){
            for(int j=1; j<=N; j++){
                if(j - M >= 0)
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M] + train[j] - train[j-M]);
            }
        }
        System.out.println(dp[3][N]);
    }
}
