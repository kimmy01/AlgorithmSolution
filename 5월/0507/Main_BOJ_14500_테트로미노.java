package com.algo0507;
import java.io.*;
import java.util.*;
public class Main_BOJ_14500_테트로미노 {
    static int N, M, max;
    static int[][] map;
    static int[][] tetrominoR = {
            {0, 1, 0, 1},
            {0, 1, 2, 3}, {0, 0, 0, 0},
            {0, 1, 2, 2}, {0, 1, 2, 2}, {0, 0, 1, 2}, {0, 0, 1, 2}, {0, 1, 1, 1}, {0, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 0, 1},
            {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 0, 1, 1}, {0, 0, 1, 1},
            {0, 0, 0, 1}, {0, 1, 1, 2}, {0, 1, 1, 2}, {0, 1, 1, 1}
    };
    static int[][] tetrominoC = {
            {0, 0, 1, 1},
            {0, 0, 0, 0}, {0, 1, 2, 3},
            {0, 0, 0, 1}, {0, 0, 0, -1}, {0, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 1, 2}, {0, 0, -1, -2}, {0, 1, 2, 0}, {0, 1, 2, 2},
            {0, 0, 1, 1}, {0, 0, -1, -1}, {0, 1, -1, 0}, {0, 1, 1, 2},
            {0, 1, 2, 1}, {0, -1, 0, 0}, {0, 0, 1, 0}, {0, -1, 0, 1}
    };
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                func(i, j);
            }
        }
        System.out.println(max);
    }
    static void func(int r, int c){
        for(int i=0; i<19; i++){
            int flag = 0;
            int sum = 0;
            for(int j=0; j<4; j++){
                int nr = r+tetrominoR[i][j];
                int nc = c+tetrominoC[i][j];
                if(inRange(nr, nc)){
                    sum += map[nr][nc];
                }else{
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                max = Math.max(max, sum);
            }
        }
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<N && 0<=nc && nc<M) return true;
        return false;
    }
}
