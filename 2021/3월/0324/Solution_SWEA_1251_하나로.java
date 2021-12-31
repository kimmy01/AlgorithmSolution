package com.algo0324;

import java.util.*;
import java.io.*;

public class Solution_SWEA_1251_하나로 {
    private static class Node {
        int x;
        int y;
        double weight;

        public Node(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static int N;
    static double rate;
    static Node[] node;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            node = new Node[N];
            parent = new int[N];
            int[] x = new int[N];
            int[] y = new int[N];
            ArrayList<Node> weightList = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                y[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                node[i] = new Node(x[i], y[i], 0);
            }
            rate = Double.parseDouble(br.readLine());

            for(int i=0; i<N; i++){
                parent[i] = i;
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    weightList.add(new Node(i, j, calDistance(node[i].x, node[i].y, node[j].x, node[j].y)));
                }
            }

            Collections.sort(weightList, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.weight < o2.weight) {
                        return -1;
                    } else if (o1.weight > o2.weight) {
                        return 1;
                    }
                    return 0;
                }
            });
            double answer = 0;
            for (int i = 0; i < weightList.size(); i++) {
                if (Find(weightList.get(i).x) != Find(weightList.get(i).y)) {
                    Union(weightList.get(i).x, weightList.get(i).y);
                    answer += weightList.get(i).weight;
                }
            }
            long ans = (long) Math.round(answer);
            System.out.println("#" + t + " " + ans);
        }
    }

    static double calDistance(long ax, long ay, long bx, long by) {
        return rate * (Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    static void Union(int a, int b) {
        a = Find(a);
        b = Find(b);
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    static int Find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = Find(parent[x]);
    }
}