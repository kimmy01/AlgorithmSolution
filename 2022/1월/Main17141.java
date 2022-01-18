package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main17141 {
    private static class Virus {
        int r;
        int c;
        int t;

        public Virus(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int N, M, answer;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int vacant;
    static Virus[] selectedVirus;
    static ArrayList<Virus> viruses;

    public static void main(String[] args) throws Exception {
        input();
        func();
    }

    static void func() {
        comb(0, 0);
        if (answer == 123456789) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    static void spreadVirus() {
        int[][] spreadMap = copyMap();
        boolean[][] visited = new boolean[N][N];
        int newVacant = vacant - M;
        Queue<Virus> queue = new LinkedList<>();
        for (Virus virus : selectedVirus) {
            spreadMap[virus.r][virus.c] = 0;
            visited[virus.r][virus.c] = true;
            queue.add(virus);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            Virus now = queue.poll();
            time = Math.max(time, now.t);
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                int nt = now.t + 1;
                if (0 <= nr && nr < N && 0 <= nc && nc < N && spreadMap[nr][nc] == -2 && !visited[nr][nc]) {
                    queue.add(new Virus(nr, nc, nt));
                    spreadMap[nr][nc] = nt;
                    visited[nr][nc] = true;
                    newVacant--;
                }
            }
        }
        if (newVacant == 0) {
            answer = Math.min(answer, time);
        }
    }

    static int[][] copyMap() {
        int[][] copied = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copied[i][j] = map[i][j];
            }
        }
        return copied;
    }

    static void comb(int start, int count) {
        if (count == M) {
            spreadVirus();
            return;
        }
        for (int i = start; i < viruses.size(); i++) {
            selectedVirus[count] = viruses.get(i);
            comb(i + 1, count + 1);
        }
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        viruses = new ArrayList<>();
        selectedVirus = new Virus[M];
        answer = 123456789;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) { //벽 -1
                    map[i][j] = -1;
                } else if (a == 2) { //바이러스 가능한 곳 0
                    map[i][j] = -2;
                    viruses.add(new Virus(i, j, 0));
                    vacant++;
                } else { //빈칸 0
                    map[i][j] = -2;
                    vacant++;
                }
            }
        }
    }
}
