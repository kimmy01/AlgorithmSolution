package com.algo0329;

import java.util.*;
import java.io.*;

public class Main_BOJ_14923_미로탈출 {
    static int N, M, startR, startC, endR, endC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        input();
        int answer = BFS();
        System.out.println(answer);
    }

    static int BFS() {
        int cnt = 0;
        boolean[][][] visited = new boolean[2][N][M];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC, 0});
        visited[0][startR][startC] = true;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            while (size > 0) {
                size--;
                int[] temp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = temp[0] + dr[i];
                    int nc = temp[1] + dc[i];
                    if (inRange(nr, nc)) {
                        if (map[nr][nc] == 1) {
                            if (temp[2] == 0 && !visited[temp[2] + 1][nr][nc]) {
                                if (nr == endR && nc == endC) return cnt;
                                q.add(new int[]{nr, nc, temp[2] + 1});
                                visited[temp[2] + 1][nr][nc] = true;
                            }
                        } else {
                            if (!visited[temp[2]][nr][nc]) {
                                if (nr == endR && nc == endC) return cnt;
                                q.add(new int[]{nr, nc, temp[2]});
                                visited[temp[2]][nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean inRange(int nr, int nc) {
        if (0 <= nr && nr < N && 0 <= nc && nc < M) {
            return true;
        }
        return false;
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        startR = stoi(st.nextToken()) - 1;
        startC = stoi(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine(), " ");
        endR = stoi(st.nextToken()) - 1;
        endC = stoi(st.nextToken()) - 1;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }
    }
}
