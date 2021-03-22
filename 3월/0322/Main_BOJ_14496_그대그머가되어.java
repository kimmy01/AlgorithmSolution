package com.algo0322;
import java.util.*;
import java.io.*;
public class Main_BOJ_14496_그대그머가되어 {
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
        int a = stoi(st.nextToken());
        int b = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());
        int INFINITY = Integer.MAX_VALUE;
        int[] distance = new int[N+1];
        arrayList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arrayList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int temp1 = stoi(st.nextToken());
            int temp2 = stoi(st.nextToken());
            arrayList[temp1].add(new Node(temp2, 1));
            arrayList[temp2].add(new Node(temp1, 1));
        }
        Arrays.fill(distance, INFINITY);
        distance[a] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(a, distance[a]));
        Node current = null;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(distance[current.vertex] < current.totalDistance) continue;
            for(int i=0; i<arrayList[current.vertex].size(); i++){
                int tempIdx = arrayList[current.vertex].get(i).vertex;
                int tempD = current.totalDistance + arrayList[current.vertex].get(i).totalDistance;
                if(distance[tempIdx] > tempD){
                    distance[tempIdx] = tempD;
                    queue.add(new Node(tempIdx, tempD));
                }
            }
        }
        if(distance[b] == INFINITY){
            System.out.println(-1);
        }else{
            System.out.println(distance[b]);
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}