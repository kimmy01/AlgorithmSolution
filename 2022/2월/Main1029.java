package com.algo2022_02;

import java.io.*;

public class Main1029 {
    static int N, max;
    static int[][] artist;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        sale(1, 1, 1);
        System.out.println(max);
    }
    static void sale(int now, int state, int visitedCnt) {
        if(max == N) return;
        max = Math.max(visitedCnt, max);

        if(state == (1 << N)-1) return;

        for(int i=1; i<=N; i++){
            int next = 1 << (i-1);
            if((state & next) == 0 && artist[now][i] >= dp[state][now]) { //방문하지 않았고 구매할 수 있다
                if(dp[state | next][i] != 0 && dp[state | next][i] <= artist[now][i]) continue; //방문했는데..이미 저장된 값이 더 작을 때
                dp[state | next][i] = artist[now][i]; //방문처리하고 값 추가
                sale(i, state | next, visitedCnt+1);
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        artist = new int[N+1][N+1];
        dp = new int[1<<N][N+1];
        for(int i=1; i<=N; i++){
            String tmp = br.readLine();
            for(int j=1; j<=N; j++){
                artist[i][j] = tmp.charAt(j-1) - '0';
            }
        }
    }
}
