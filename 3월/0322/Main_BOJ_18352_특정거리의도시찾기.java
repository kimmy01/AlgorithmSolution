package com.algo0322;
import java.io.*;
import java.util.*;
public class Main_BOJ_18352_특정거리의도시찾기 {
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
        int N = stoi(st.nextToken()); //도시개수
        int M = stoi(st.nextToken()); //도로개수
        int K = stoi(st.nextToken()); //거리정보(가중치)
        int X = stoi(st.nextToken()); //출발도시번호
        int INFINITY = Integer.MAX_VALUE;

        int[] distance = new int[N+1];
        arrayList = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            arrayList[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            arrayList[a].add(new Node(b, 1));
        }
        Arrays.fill(distance, INFINITY);
        distance[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, distance[X]));
        Node current = null;
        while(!pq.isEmpty()){
            current = pq.poll();
            if(distance[current.vertex] < current.totalDistance) continue;
            for(int i=0; i<arrayList[current.vertex].size(); i++){
                int tempIdx = arrayList[current.vertex].get(i).vertex;
                int tempD = current.totalDistance + arrayList[current.vertex].get(i).totalDistance;
                if(distance[tempIdx] > tempD){
                    distance[tempIdx] = tempD;
                    pq.offer(new Node(tempIdx, tempD));
                }
            }
        }
        ArrayList<Integer> selected = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(distance[i] == K){
                selected.add(i);
            }
        }
        if(selected.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(selected);
            for(int i=0; i<selected.size(); i++){
                System.out.println(selected.get(i));
            }
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}