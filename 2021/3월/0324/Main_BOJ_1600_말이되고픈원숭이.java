package com.algo0324;

import java.io.*;
import java.util.*;

public class Main_BOJ_1600_말이되고픈원숭이 {
    static int K, H, W, answer;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = stoi(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        W = stoi(st.nextToken());
        H = stoi(st.nextToken());
        answer = -1;
        map = new int[H][W];
        visited = new boolean[K + 1][H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < W; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
        BFS();
        System.out.println(answer);
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] knight = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, -2}, {1, -2}, {-1, 2}, {1, 2}}; //상우, 상좌, 하우, 하좌, 좌우, 좌좌, 우우, 우좌

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0}); //K, R, C, cnt
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[1] == H - 1 && temp[2] == W - 1) {
                answer = temp[3];
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nMap = temp[0];
                int nr = temp[1] + dr[i];
                int nc = temp[2] + dc[i];
                int cnt = temp[3];
                if (inRange(nr, nc) && map[nr][nc] == 0 && !visited[nMap][nr][nc]) {
                    visited[nMap][nr][nc] = true;
                    queue.add(new int[]{nMap, nr, nc, cnt + 1});
                }
            }
            if (temp[0] == K) continue;
            for (int i = 0; i < 8; i++) {
                int nMap = temp[0] + 1;
                int nr = temp[1] + knight[i][0];
                int nc = temp[2] + knight[i][1];
                int cnt = temp[3];
                if (inRange(nr, nc) && !visited[nMap][nr][nc] && map[nr][nc] == 0) {
                    visited[nMap][nr][nc] = true;
                    queue.add(new int[]{nMap, nr, nc, cnt + 1});
                }
            }
        }
    }

    static boolean inRange(int nr, int nc) {
        if (0 <= nr && nr < H && 0 <= nc && nc < W) {
            return true;
        }
        return false;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}