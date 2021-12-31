package com.algo0406;
import java.io.*;
import java.util.*;
public class Main_BOJ_1520_내리막길 {
    static int N, M;
    static int[][] map, dp;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(DFS(0, 0));
    }
    static int DFS(int r, int c){
        if(r == N-1 && c == M-1) return 1;
        if(dp[r][c] != -1) return dp[r][c];
        dp[r][c] = 0;
        for(int i=0; i<4; i++){
            int nr = r+dr[i];
            int nc = c+dc[i];
            if(inRange(nr, nc)){
                if(map[r][c] > map[nr][nc]) dp[r][c] += DFS(nr, nc);
            }
        }
        return dp[r][c];
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
}
