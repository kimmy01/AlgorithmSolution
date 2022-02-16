package com.algo2022_02;

import java.io.*;

public class Main5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] dp = new int[M];
        int answer = 0;
        for(int i=1; i<M-1; i++){
            if(arr[i] == 'O' && arr[i+1] == 'I'){
                dp[i+1] = dp[i-1]+1;
                if(dp[i+1] >= N && arr[i-2*N+1] == 'I') answer++;
            }
        }
        System.out.println(answer);
    }
}
