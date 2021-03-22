package com.algo0322;
import java.io.*;
import java.util.*;
public class Main_BOJ_1753_최단경로PQ {
    private static class Node implements Comparable<Node>{
        int vertex;
        int totalDistance;
        public Node(int vertex, int totalDistance){
            this.vertex = vertex;
            this.totalDistance = totalDistance;
        }

        @Override
        public int compareTo(Node o) {
            return this.totalDistance - o.totalDistance;
        }
    }
    static ArrayList<Node>[] arrayList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int INFINITY = Integer.MAX_VALUE;

        int[] distance = new int[V+1];
        arrayList = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList[u].add(new Node(v, w));
        }

        Arrays.fill(distance, INFINITY);
        distance[K] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(K, distance[K]));

        Node current = null;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(distance[current.vertex] < current.totalDistance)continue;
            for(int i=0; i<arrayList[current.vertex].size(); i++){
                int tempIdx = arrayList[current.vertex].get(i).vertex;
                int tempD = current.totalDistance + arrayList[current.vertex].get(i).totalDistance;

                if(distance[tempIdx] > tempD){
                    distance[tempIdx] = tempD;
                    queue.add(new Node(tempIdx, tempD));
                }
            }
        }
        for(int i=1; i<=V; i++){
            if(distance[i] == INFINITY){
                System.out.println("INF");
            }else{
                System.out.println(distance[i]);
            }
        }
    }
}