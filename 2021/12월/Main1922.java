package com.algo12;

import java.util.*;
import java.io.*;

public class Main1922 {
    static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int w;
        public Edge(int a, int b, int w){
            this.a = a;
            this.b = b;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
    static int N, M, answer;
    static int[] parent, weight;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        answer = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.a) != find(edge.b)){
                union(edge.a, edge.b);
                answer += edge.w;
            }
        }
        System.out.println(answer);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        weight = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(a, b, w));
        }
    }
}
