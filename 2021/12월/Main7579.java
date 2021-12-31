package com.algo12;

import java.io.*;
import java.util.*;

public class Main7579 {
    static int N, M, answer;
    static int[][] apps;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        input();
        knapsack();
    }
    static void knapsack() {
        dp = new int[N+1][10001];
        for(int i=1; i<=N; i++){
            for(int j=0; j<=10000; j++){
                if(apps[i][1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-apps[i][1]] + apps[i][0]);
                }
            }
        }
        for(int i=1; i<=10001; i++){
            if(dp[N][i] >= M){
                System.out.println(i);
                return;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        apps = new int[N+1][N+1];
        answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            apps[i][0] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            apps[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
