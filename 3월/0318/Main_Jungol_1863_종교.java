package com.algo0318;
import java.util.*;
import java.io.*;
public class Main_Jungol_1863_종교 {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        for(int i=1; i<=N; i++){
            find(i);
        }
        int cnt = 0;
        int religion = 0;
        Arrays.sort(parent);
        for(int i=1; i<=N; i++){
            if(parent[i] == 0){
                continue;
            }
            if(religion != parent[i]){
                religion = parent[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static int find(int x){
        if(x == parent[x]){
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
}