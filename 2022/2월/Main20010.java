package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main20010 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int cost;
        public Edge(int a, int b, int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
        public Edge(int b, int cost){
            this.b = b;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o){
            return this.cost - o.cost;
        }
    }
    static int N, K, answer1, answer2, start;
    static int[] parent, cost;
    static ArrayList<Edge>[] MST;
    static boolean[] visited;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        kruskal();
        answer2 = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[0] = true;
        dfs(0, 0);

        answer2 = Integer.MIN_VALUE;
        visited = new boolean[N];
        visited[start] = true;
        dfs(start, 0);
        System.out.println(answer1);
        System.out.println(answer2);
    }
    static void kruskal() { //MST구하기
        answer1 = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(find(now.a) != find(now.b)){
                union(now.a, now.b);
                MST[now.a].add(new Edge(now.b, now.cost));
                MST[now.b].add(new Edge(now.a, now.cost));
                answer1 += now.cost;
            }
        }
    }
    static void dfs(int edge, int total) {
        if(answer2 < total) {
            answer2 = total;
            start = edge;
        }
        for(int i=0; i<MST[edge].size(); i++){
            Edge next = MST[edge].get(i);
            if(!visited[next.b]){
                visited[next.b] = true;
                dfs(next.b, total + next.cost);
            }
        }
    }
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        parent = new int[N];
        cost = new int[N];
        MST = new ArrayList[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
            MST[i] = new ArrayList<>();
        }
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, cost));
        }
    }
}
