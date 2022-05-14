package com.algo2022_05;

import java.io.*;
import java.util.*;

public class Main17845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] important = new int[K+1];
        int[] study = new int[K+1];
        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            important[i] = Integer.parseInt(st.nextToken());
            study[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[][] dp = new int[K+1][N+1];
        for(int i=1; i<=K; i++){
            for(int j=1; j<=N; j++){ //시간 제한
                if(study[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-study[i]]+important[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }
}
