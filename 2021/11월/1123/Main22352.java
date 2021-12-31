package com.algo11;

import java.util.*;
import java.io.*;

public class Main22352 {
    static String answer;
    static int N, M;
    static int[][] before;
    static int[][] after;
    static int[] dx = {-1, 0, 1, 0}; // 상우하좌
    static int[] dy = {0, 1, 0, -1}; // 상우하좌
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        loop: for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(before[i][j] != after[i][j]){
                    int[][] input = copy(before);
                    int[][] spread = dfs(i, j, input, before[i][j], after[i][j]);
                    if(changed(spread, after)) {
                        continue;
                    }else{
                        answer = "NO";
                        break loop;
                    }
                }
            }
        }
        System.out.println(answer);
    }
    private static int[][] dfs(int x, int y, int[][] arr, int beforeNum, int afterNum){
        arr[x][y] = afterNum;
        for(int i=0; i<4; i++){
            if(isValid(x+dx[i], y+dy[i]) && arr[x+dx[i]][y+dy[i]] == beforeNum){
                dfs(x+dx[i], y+dy[i], arr, beforeNum, afterNum);
            }
        }
        return arr;
    }
    private static boolean changed(int[][] before, int[][] after){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(before[i][j] != after[i][j]) return false;
            }
        }
        return true;
    }
    private static int[][] copy(int[][] original){
        int[][] copied = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                copied[i][j] = original[i][j];
            }
        }
        return copied;
    }
    private static boolean isValid(int x, int y) {
        if(0 <= x && N > x && 0 <= y && M > y) return true;
        return false;
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        answer = "YES";
        before = new int[N][M];
        after = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                before[i][j] = stoi(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                after[i][j] = stoi(st.nextToken());
            }
        }
    }
    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
