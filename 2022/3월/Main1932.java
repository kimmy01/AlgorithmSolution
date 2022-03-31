package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()){
                dp[i][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }
        for(int i=1; i<N; i++){
            for(int j=0; j<i+1; j++){
                if(j == 0){
                    dp[i][j] += dp[i-1][j];
                }else if(j == i){
                    dp[i][j] += dp[i-1][j-1];
                }else{
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }
        Arrays.sort(dp[N-1]);
        System.out.println(dp[N-1][N-1]);
    }
}
