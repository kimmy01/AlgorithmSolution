package com.algo0328;

import java.util.*;
import java.io.*;

public class Main_BOJ_2178_미로탐색 {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0' - 2;
                if (i == 0 && j == 0) map[i][j] = 1;
            }
        }
        BFS();
        System.out.println(map[N - 1][M - 1]);
    }

    static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int[] temp = null;
        while (!q.isEmpty()) {
            temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = temp[0] + dr[i];
                int nc = temp[1] + dc[i];
                if (inRange(nr, nc) && map[nr][nc] == -1) {
                    map[nr][nc] = map[temp[0]][temp[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
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
