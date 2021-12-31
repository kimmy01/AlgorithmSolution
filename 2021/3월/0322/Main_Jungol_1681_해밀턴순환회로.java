package com.algo0322;
import java.util.*;
import java.io.*;
public class Main_Jungol_1681_해밀턴순환회로 {
    static int N;
    static int[][] map;
    static int minCost;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                int w = Integer.parseInt(st.nextToken());
                map[i][j] = w;
            }
        }
        minCost  = Integer.MAX_VALUE;
        visited[1] = true;
        dfs(1, 1, 0);
        System.out.println(minCost);
    }
    static void dfs(int current, int cnt, int cost){
        if(cnt == N){
            if(map[current][1] == 0) return;
            cost += map[current][1];
            minCost = Math.min(minCost, cost);
            return;
        }
        if(cost > minCost) return;
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            if(map[current][i] == 0) continue;
            visited[i] = true;
            dfs(i, cnt+1, cost+map[current][i]);
            visited[i] = false;
        }
    }
}