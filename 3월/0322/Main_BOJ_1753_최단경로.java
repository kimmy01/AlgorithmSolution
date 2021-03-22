package com.algo0322;
import java.io.*;
import java.util.*;
public class Main_BOJ_1753_최단경로 {
    static int V, E, K, INFINITY;
    static int[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        INFINITY = Integer.MAX_VALUE;

        map = new int[V+1][V+1];
        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u][v] = w;
        }

        int min = 0;
        int current = 1;

        Arrays.fill(distance, INFINITY);
        distance[K] = 0;

        for(int i=1; i<=V; i++){
            min = INFINITY;
            for(int j=1; j<=V; j++){
                if(!visited[j] && distance[j] < min){
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if(current == V) break;
            for(int c=1; c<=V; c++){
                if(!visited[c] && map[current][c]!=0 &&
                        distance[c] > min+map[current][c]){
                    distance[c] = min+map[current][c];
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