package com.algo0327;

import java.util.*;
import java.io.*;

public class Main_BOJ_11650_좌표정렬하기Comparable {
    private static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x > o.x) {
                return 1;
            }
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x, y);
        }
        Arrays.sort(nodes);
        for (int i = 0; i < N; i++) {
            System.out.print(nodes[i].x + " ");
            System.out.println(nodes[i].y);
        }
    }
}
