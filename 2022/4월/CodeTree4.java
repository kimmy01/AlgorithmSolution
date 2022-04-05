package com.algo2022_04;

import java.io.*;
import java.util.*;

public class CodeTree4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][][] dp = new int[2][n+1][n+1];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                dp[0][i][j] = Math.max(dp[0][i-1][j], dp[0][i][j-1]) + map[i][j];
                dp[1][i][j] = Math.max(dp[0][i][j], Math.max(dp[1][i-1][j], dp[1][i][j-1])) + map[i][j];
            }
        }
        System.out.println(Math.max(dp[0][n-1][n-1], dp[1][n-1][n-1]));
    }
}
