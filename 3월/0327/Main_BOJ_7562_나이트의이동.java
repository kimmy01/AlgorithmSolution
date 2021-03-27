package com.algo0327;

import java.util.*;
import java.io.*;

public class Main_BOJ_7562_나이트의이동 {
    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int I;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            I = stoi(br.readLine());
            map = new int[I][I];
            st = new StringTokenizer(br.readLine(), " ");
            int knightR = stoi(st.nextToken());
            int knightC = stoi(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int destinationR = stoi(st.nextToken());
            int destinationC = stoi(st.nextToken());
            BFS(knightR, knightC);
            System.out.println(map[destinationR][destinationC] - 1);
        }
    }

    static void BFS(int knightR, int knightC) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(knightR, knightC));
        map[knightR][knightC] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 8; i++) {
                int nr = node.r + dir[i][0];
                int nc = node.c + dir[i][1];
                if (inRange(nr, nc) && map[nr][nc] == 0) {
                    map[nr][nc] += map[node.r][node.c] + 1;
                    q.add(new Node(nr, nc));
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean inRange(int nr, int nc) {
        if (0 <= nr && nr < I && 0 <= nc && nc < I) return true;
        return false;
    }
}
