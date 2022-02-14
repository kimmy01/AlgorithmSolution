package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11724 {
    static int N, M;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            union(u, v);
            union(v, u);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int n : parent){
            set.add(find(n));
        }
        System.out.println(set.size()-1);
    }
    private static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}
