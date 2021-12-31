package com.algo0312;
import java.util.*;
import java.io.*;
public class Main_BOJ_12865_평범한배낭 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken()); //물건 수
        int K = Integer.parseInt(stk.nextToken()); //최대 무게
        int[][] dp = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] p = new int[K+1];
        for(int i=1; i<=N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            w[i] = Integer.parseInt(stk.nextToken());
            p[i] = Integer.parseInt(stk.nextToken());
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=w[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+p[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
