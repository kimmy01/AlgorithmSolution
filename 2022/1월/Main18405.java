package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main18405 {
    static int N, K, S, X, Y;
    static int[][] cylinder;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    static void func() {
        loop: for(int i=0; i<S; i++){
            for(int j=1; j<=K; j++){
                spread(j);
                if(cylinder[X][Y] != 0) break loop;
            }
        }
        System.out.println(cylinder[X][Y]);
    }
    static void spread(int num){
        Queue<int[]> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cylinder[i][j] == num){
                    q.add(new int[]{i, j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int k=0; k<4; k++){
                int nr = now[0] + dr[k];
                int nc = now[1] + dc[k];
                if(inRange(nr, nc) && cylinder[nr][nc] == 0){
                    cylinder[nr][nc] = num;
                }
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<nr && nr<=N && 0<nc && nc<=N) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cylinder = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                cylinder[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}
