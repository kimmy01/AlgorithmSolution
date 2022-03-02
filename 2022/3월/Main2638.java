package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main2638 {
    static int N, M, answer;
    static int[][] cheese;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        while(true){
            if(check()){
                System.out.println(answer);
                break;
            }else {
                answer++;
                checkOutside();
                meltCheese();
            }
        }
    }
    static void checkOutside() {
        boolean[][] visited = new boolean[N+1][M+1];
        Queue<int[]> q = new LinkedList<>();
        visited[1][1] = true;
        cheese[1][1] = -1;
        q.add(new int[]{1, 1});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(inRange(nr, nc) && !visited[nr][nc] && cheese[nr][nc] == 0){
                    cheese[nr][nc] = -1;
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
    static void meltCheese() {
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int outCnt = 0;
            for(int i=0; i<4; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(cheese[nr][nc] == -1) outCnt++;
            }
            if(outCnt >= 2) cheese[now[0]][now[1]] = 2;
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(cheese[i][j] == -1 || cheese[i][j] == 2) cheese[i][j] = 0;
                else if(cheese[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
    }
    static boolean check() {
        boolean flag = true;
        loop: for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(cheese[i][j] == 1){
                    flag = false;
                    break loop;
                }
            }
        }
        if(flag) return true;
        return false;
    }
    static boolean inRange(int r, int c){
        if(0<r && r<=N && 0<c && c<=M) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cheese = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=M; j++){
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if(cheese[i][j] == 1) queue.add(new int[]{i, j});
            }
        }
    }
}
