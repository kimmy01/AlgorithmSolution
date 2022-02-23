package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1167 {
    static class Edge{
        int end;
        int weight;
        public Edge(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    static class Node{
        int idx;
        int cnt;
        public Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    static int N;
    static int result = 0;
    static int max = 0;
    static ArrayList<Edge>[] nodeList;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodeList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken());
            while(true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                nodeList[idx].add(new Edge(num, weight));
            }
        }
        func(1);
        func(max);
        System.out.println(result);
    }
    static void func(int start){
        boolean[] visited = new boolean[N+1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start] = true;
        int maxCnt = 0;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.cnt > maxCnt){
                maxCnt = now.cnt;
                max = now.idx;
            }
            for(Edge e : nodeList[now.idx]){
                if(!visited[e.end]){
                    visited[e.end] = true;
                    queue.add(new Node(e.end, now.cnt+e.weight));
                }
            }
        }
        result = Math.max(result, maxCnt);
    }
}
