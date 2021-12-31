package com.algo12;

import java.util.*;
import java.io.*;

public class Main5913 {
    static int K, answer;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        input();
        dfs(1, 0, 0);
        System.out.println(answer);
    }
    static void dfs(int size, int r, int c) {
        if(r == 4 && c == 4){ //맨끝까지 갔다면
            if(size == 25-K) answer++;
        }
        map[r][c] = -1; //방문 체크
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(inRange(nr, nc) && map[nr][nc] != -1){
                dfs(size+1, nr, nc);
            }
        }
        map[r][c] = 0; //방문 해제
    }
    static boolean inRange(int nr, int nc){
        if(0<=nr && nr<5 && 0<=nc && nc<5) return true;
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        K = Integer.parseInt(br.readLine());
        map = new int[5][5];
        StringTokenizer st;
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = -1; //나무 없는 곳
        }
    }
}
