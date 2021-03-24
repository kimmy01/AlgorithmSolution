package com.algo0324;
import java.util.*;
import java.io.*;
public class Main_BOJ_14938_서강그라운드 {
    private static class Node implements Comparable<Node>{
        int vertex;
        int distance;
        public Node(int vertex, int distance){
            this.vertex = vertex;
            this.distance = distance;
        }
        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static int n, m, r;
    static int[] item;
    static ArrayList<Node>[] arrayList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        r = stoi(st.nextToken());
        item = new int[n+1];
        arrayList = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=n; i++){
            arrayList[i] = new ArrayList<>();
            item[i] = stoi(st.nextToken());
        }
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int road = stoi(st.nextToken());
            arrayList[a].add(new Node(b, road));
            arrayList[b].add(new Node(a, road));
        }
        int answer = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            answer = Math.max(answer, dijkstra(i));
        }
        System.out.println(answer);
    }
    static int dijkstra(int v){
        int[] distance = new int[n+1];
        Arrays.fill(distance, 100000000);
        distance[v] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(v, distance[v]));
        Node current = null;
        while(!queue.isEmpty()){
            current = queue.poll();
            if(distance[current.vertex] < current.distance) continue;
            for(int i=0; i<arrayList[current.vertex].size(); i++){
                int tempIdx = arrayList[current.vertex].get(i).vertex;
                int tempD = current.distance + arrayList[current.vertex].get(i).distance;
                if(distance[tempIdx] > tempD){
                    distance[tempIdx] = tempD;
                    queue.add(new Node(tempIdx, tempD));
                }
            }
        }
        int itemCnt = 0;
        for(int i=1; i<=n; i++){
            if(distance[i] <= m){
                itemCnt += item[i];
            }
        }
        return itemCnt;
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}