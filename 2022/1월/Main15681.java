package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main15681 {
    static int N, R, Q;
    static ArrayList<Integer>[] treeList;
    static boolean[] visited;
    static int[] dp;
    static int[] query;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        dfs(R);
        for(int i=0; i<Q; i++){
            System.out.println(dp[query[i]]);
        }
    }
    static int dfs(int N) {
        visited[N] = true;
        dp[N] = 1;
        for(int i=0; i<treeList[N].size(); i++){
            int sub = treeList[N].get(i);
            if(!visited[sub]){
                dp[N] += dfs(sub);
            }
        }
        return dp[N];
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //노드개수
        R = Integer.parseInt(st.nextToken()); //루트번호
        Q = Integer.parseInt(st.nextToken()); //쿼리개수
        treeList = new ArrayList[N+1];
        visited = new boolean[N+1];
        dp = new int[N+1];
        query = new int[Q];
        for(int i=0; i<=N; i++){
            treeList[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            treeList[u].add(v);
            treeList[v].add(u);
        }
        for(int i=0; i<Q; i++){
            query[i] = Integer.parseInt(br.readLine());
        }
    }
}
