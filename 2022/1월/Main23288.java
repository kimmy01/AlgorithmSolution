package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main23288 {
    static int N, M, K, d, r, c, answer;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    //북 => 1열의 세로 줄을 북쪽으로 한 칸씩 이동
    //남 => 1열의 세로 줄을 남쪽으로 한 칸씩 이동
    //바닥면이 바뀌므로, (1,3), (3,1) 동일하게 유지 시키기
    static int[][] dice = { //주사위 초기 도면
            {0, 2, 0, 0},
            {4, 1, 3, 6}, //(1,3) 바닥
            {0, 5, 0, 0},
            {0, 6, 0, 0}}; //(3,1) 바닥
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<K; i++){
            move();
        }
        System.out.println(answer);
    }
    private static void move() {
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
            d = (d + 2) % 4;
            nr = r + dr[d];
            nc = c + dc[d];
        }
        r = nr;
        c = nc;
        if (d == 0) { // 상
            int tmp = dice[0][1];
            for (int i = 0; i < 3; i++) {
                dice[i][1] = dice[i + 1][1];
            }
            dice[3][1] = tmp;
            dice[1][3] = dice[3][1];
        } else if (d == 1) {// 우
            int tmp = dice[1][3];
            for(int j = 3; j > 0; j--) {
                dice[1][j] = dice[1][j-1];
            }
            dice[1][0] = tmp;
            dice[3][1] = dice[1][3];
        } else if (d == 2) {// 하
            int tmp = dice[3][1];
            for (int i = 3; i > 0; i--) {
                dice[i][1] = dice[i - 1][1];
            }
            dice[0][1] = tmp;
            dice[1][3] = dice[3][1];
        } else {// 좌
            int tmp = dice[1][0];
            for(int j = 0; j < 3; j++) {
                dice[1][j] = dice[1][j+1];
            }
            dice[1][3] = tmp;
            dice[3][1] = dice[1][3];
        }
        answer += getScores();
        int A = dice[1][3];
        int B = map[r][c];
        if(A > B) {
            d = (d+1) % 4;
        }else if(A < B) {
            d = (d-1 < 0)? 3 : d-1;
        }
    }
    private static int getScores() {
        int B = map[r][c];
        int C = 0;
        boolean visit[][] = new boolean[N][M];
        visit[r][c] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            C++;
            for (int d = 0; d < 4; d++) {
                int nr = p[0] + dr[d];
                int nc = p[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || map[nr][nc] != B)
                    continue;
                visit[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
        return B * C;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        d = 1;
        r = 0;
        c = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
