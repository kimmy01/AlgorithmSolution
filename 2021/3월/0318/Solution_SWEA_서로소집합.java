package com.algo0318;
import java.io.*;
import java.util.*;
public class Solution_SWEA_서로소집합 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for(int t=1; t<=T; t++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = stoi(st.nextToken()); //n개의 집합
            m = stoi(st.nextToken()); //연산의 수
            parent = new int[n+1];
            init();
            //0은 union 1은 find
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int dir = stoi(st.nextToken());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                if(dir == 0){
                    union(a, b);
                }else{
                    if(find(a) == find(b)){
                        sb.append(1);
                    }else{
                        sb.append(0);
                    }
                }
            }
            System.out.println("#"+t+" "+sb);
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
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
    static int find(int n){
        if(n == parent[n]){
            return parent[n];
        }else{
            return parent[n] = find(parent[n]);
        }
    }
    static void init(){
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }
}