package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main1504 {
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, E, must1, must2;
    static int[] distance;
    static ArrayList<ArrayList<Node>> nodes;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        // 1번 => must1 => must2 => N번
        int result1 = 0;
        result1 += dijkstra(1, must1);
        result1 += dijkstra(must1, must2);
        result1 += dijkstra(must2, N);

        // 1번 => must2 => must1 => N번
        int result2 = 0;
        result2 += dijkstra(1, must2);
        result2 += dijkstra(must2, must1);
        result2 += dijkstra(must1, N);

        if(result1 >= 200000000 && result2 >= 200000000){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(result1, result2));
        }
    }
    static int dijkstra(int start, int end) {
        Arrays.fill(distance, 200000000);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N+1];
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()){
            Node current = pq.poll();
            int currentEnd = current.end;
            if(!check[currentEnd]){
                check[currentEnd] = true;
                for(Node node : nodes.get(currentEnd)){
                    if(!check[node.end] && distance[node.end] > distance[currentEnd] + node.weight){ //해당 정점 방문X && 해당정점의 거리가 현재정점+현재정점의거리보다 큰 경우
                        distance[node.end] = distance[currentEnd] + node.weight;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        return distance[end];
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N+1];
        nodes = new ArrayList<>();
        Arrays.fill(distance, 200000000);
        for(int i=0; i<=N; i++){
            nodes.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            Node node1 = new Node(end, weight);
            Node node2 = new Node(start, weight);
            nodes.get(start).add(node1);
            nodes.get(end).add(node2);
        }
        st = new StringTokenizer(br.readLine()," ");
        must1 = Integer.parseInt(st.nextToken());
        must2 = Integer.parseInt(st.nextToken());
    }
}
