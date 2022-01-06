package com.algo2022_01;

import java.io.*;
import java.util.*;

public class Main1520 {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(dfs(0, 0));
    }
    static int dfs(int r, int c){
        if(r == N-1 && c == M-1) return 1;
        if(dp[r][c] > -1) return dp[r][c];
        dp[r][c] = 0;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(inRange(nr, nc) && map[r][c] > map[nr][nc]){
                dp[r][c] += dfs(nr, nc);
            }
        }
        return dp[r][c];
    }
    static boolean inRange(int r, int c){
        if(0 <= r && r < N && 0 <= c && c < M) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }
    }
}
