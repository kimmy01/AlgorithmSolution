package com.algo12;

import java.io.*;
import java.util.StringTokenizer;

public class Main7570 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int student = Integer.parseInt(st.nextToken());
            dp[student] = dp[student-1]+1;
            if(dp[student] > max) max = dp[student];
        }
        System.out.println(N-max);
    }
}
