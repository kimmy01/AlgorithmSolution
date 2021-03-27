package com.algo0327;

import java.util.*;
import java.io.*;

public class Main_BOJ_1012_유기농배추 {
    private static class Cabbage {
        int x;
        int y;

        public Cabbage(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, K;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static Cabbage[] cabbages;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = stoi(st.nextToken());//가로길이
            N = stoi(st.nextToken());//세로길이
            K = stoi(st.nextToken());//배추위치
            map = new int[N][M];
            cabbages = new Cabbage[K];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = stoi(st.nextToken());
                int y = stoi(st.nextToken());
                cabbages[i] = new Cabbage(x, y);
                map[y][x] = -1;
            }
            int cnt = 1;
            for (int i = 0; i < K; i++) {
                int tempX = cabbages[i].x;
                int tempY = cabbages[i].y;
                if (map[tempY][tempX] == -1) {
                    DFS(tempX, tempY, cnt++);
                }
            }
            System.out.println(cnt - 1);
        }
    }

    static void DFS(int x, int y, int cnt) {
        map[y][x] = cnt;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (inRange(nx, ny) && map[ny][nx] == -1) {
                DFS(nx, ny, cnt);
            }
        }
    }

    static boolean inRange(int x, int y) {
        if (0 <= x && x < M && 0 <= y && y < N) return true;
        return false;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
