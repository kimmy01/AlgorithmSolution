package com.algo11;

import java.util.*;
import java.io.*;

public class Main17208 {
    static int N, M, K;
    static int[][] order;
    static int[][][] dp;
    public static void main(String[] args) throws Exception {
        input();
        int answer = func(0, M, K);
        System.out.println(answer);
    }
    private static int func(int num, int cheese, int frenchFries){
        if(num == N) return 0;
        if(dp[num][cheese][frenchFries] >= 0) return dp[num][cheese][frenchFries];
        int result = 0;
        if(order[num][0] <= cheese && order[num][1] <= frenchFries){
            result = func(num+1, cheese - order[num][0], frenchFries - order[num][1]) + 1;
        }
        result = Math.max(result, func(num+1, cheese, frenchFries));
        dp[num][cheese][frenchFries] = result;
        return result;
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        order = new int[301][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }
        dp = new int[101][301][301];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                for(int k=0; k<=K; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
    }
}
