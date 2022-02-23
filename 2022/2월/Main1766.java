package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1766 {
    static int N, M;
    static int[] inDegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            inDegree[b]++;
        }
        topologySort();
    }
    static void topologySort() {
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            result.add(now);
            for(int i=0; i<graph.get(now).size(); i++){
                inDegree[graph.get(now).get(i)]--;
                if(inDegree[graph.get(now).get(i)] == 0){
                    queue.add(graph.get(now).get(i));
                }
            }
        }
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
