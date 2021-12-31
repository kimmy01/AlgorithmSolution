package com.algo0317;
import java.io.*;
import java.util.*;
public class Main_BOJ_1976_여행가자 {
    static int N,M;
    static int[] parent;
    static int[][] city;
    static int[] plan;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = stoi(br.readLine());
        M = stoi(br.readLine());
        parent = new int[N+1];
        city = new int[N+1][N+1];
        plan = new int[M];
        //parent 배열에 각 인덱스 넣어주고, city간 연결 입력
        for(int i=1; i<=N; i++){
            parent[i] = i;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                city[i][j] = stoi(st.nextToken());
            }
        }
        //계획 저장
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            plan[i] = stoi(st.nextToken());
        }
        //도시 간 연결
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(city[i][j] == 1){
                    union(i, j);
                }
            }
        }
        if(possible()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
    static int find(int n){
        if(n == parent[n]){
            return parent[n];
        }else{
            return parent[n] = find(parent[n]);
        }
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
    static boolean possible(){
        for(int i=0; i<M; i++){
            if(parent[plan[0]] != parent[plan[i]]){
                return false;
            }
        }
        return true;
    }
}