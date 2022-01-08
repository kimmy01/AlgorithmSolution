package com.algo2022_01;

import java.io.*;
import java.util.*;

public class Main15559 {
    static int N, M, answer, groupNum;
    static int map[][];
    static int dr[] = {-1, 0, 0, 1}; //NWES
    static int dc[] = {0, -1, 1, 0}; //NWES
    static int[][] checked;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        groupNum = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(checked[i][j] == 0) {
                    dfs(i, j, groupNum);
                    groupNum++;
                }
            }
        }
        System.out.println(answer);
    }
    static void dfs(int r, int c, int groupNum) {
        checked[r][c] = groupNum;
        int nr = r + dr[map[r][c]];
        int nc = c + dc[map[r][c]];
        if(checked[nr][nc] > 0){
            if(checked[nr][nc] == groupNum){
                answer++;
                return;
            }
            return;
        }else{
            dfs(nr, nc, groupNum);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checked = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                if(s.charAt(j) == 'N'){
                    map[i][j] = 0;
                }else if(s.charAt(j) == 'W'){
                    map[i][j] = 1;
                }else if(s.charAt(j) == 'E'){
                    map[i][j] = 2;
                }else if(s.charAt(j) == 'S'){
                    map[i][j] = 3;
                }
            }
        }
    }
}
