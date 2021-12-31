package com.algo0327;

import java.util.*;
import java.io.*;

public class Main_BOJ_11650_좌표정렬하기Comparator {
    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class MyComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x > o2.x) {
                return 1;
            }
            if (o1.x == o2.x) {
                return o1.y - o2.y;
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
        MyComparator myComparator = new MyComparator();
        Arrays.sort(nodes, myComparator);
        for (int i = 0; i < N; i++) {
            System.out.print(nodes[i].x + " ");
            System.out.println(nodes[i].y);
        }
    }
}
