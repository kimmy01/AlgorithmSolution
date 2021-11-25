package com.algo11;

import java.io.*;

public class Main9657 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(int i=5; i<=1000; i++){
            if(dp[i-1]+dp[i-3]+dp[i-4] < 3){ //현재부터 한 칸 전, 세 칸 전, 네 칸 전에 한 번이라도 창영이가 가져갔다면 상근이가 이김
                dp[i] = 1;
            }else{
                dp[i] = 0;
            }
        }
        if(dp[N] == 1){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 1;
    }
}
