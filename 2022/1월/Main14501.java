package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main14501 {
    static int N;
    static int[] date;
    static int[] profit;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=2; i<=N; i++){
            for(int j=1; j<i; j++){
                if(i - j >= date[j]){ //해당 날짜에
                    dp[i] = Math.max(profit[i]+dp[j], dp[i]); //현재이익+j일까지 이익, 현재까지 이익
                }
            }
        }
        int max =0;
        for(int i=1; i<=N; i++){
            if(i+date[i] <= N+1){
                if(max < dp[i]){
                    max = dp[i];
                }
            }
        }
        System.out.println(max);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        date = new int[N+1];
        profit = new int[N+1];
        dp = new int[N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            date[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
            dp[i] = profit[i]; //각 날짜의 dp에 먼저 각 날짜 얻을 수 있는 이익으로 넣어줌
        }
    }
}
