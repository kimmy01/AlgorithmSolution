package com.algo2022_01;

import java.io.*;

public class Main2140 {
    static int N, answer;
    static char[][] map;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        if(N == 1) {
            System.out.println(0);
            return;
        }
        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                check(i, j);
            }
        }
        System.out.println(answer);
    }
    static void check(int r, int c){
        boolean flag = false;
        for(int i=0; i<8; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(map[nr][nc] != '#'){
                int num = map[nr][nc] -'0';
                if(num <= 0) flag = true;
            }
        }
        if(flag) answer--;
        else{
            for(int i=0; i<8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(map[nr][nc] != '#'){
                    map[nr][nc]--;
                }
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = (N-2)*(N-2);
        map = new char[N][N];
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = tmp.charAt(j);
            }
        }
    }
}
