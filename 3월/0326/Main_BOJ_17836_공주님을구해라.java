package com.algo0326;

import java.util.*;
import java.io.*;

public class Main_BOJ_17836_공주님을구해라 {
    static int N, M, T, swordR, swordC, min;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());
        map = new int[N][M];
        min = 1000000000;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 2) {
                    swordR = i;
                    swordC = j;
                }
            }
        }
        int min = Math.min(BFS(swordR, swordC) + ((N - 1) - swordR) + ((M - 1) - swordC), BFS(N - 1, M - 1));
        if (min <= T) {
            System.out.println(min);
        } else {
            System.out.println("Fail");
        }
    }

    static int BFS(int a, int b) {
        int[][] visited = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                if (inRange(nr, nc) && visited[nr][nc] == 0 && map[nr][nc] != 1) {
                    visited[nr][nc] = visited[temp[0]][temp[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        if (visited[a][b] != 0) {
            return visited[a][b] - 1;
        } else {
            return 1000000000;
        }
    }

    static boolean inRange(int nr, int nc) {
        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
            return true;
        }
        return false;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
