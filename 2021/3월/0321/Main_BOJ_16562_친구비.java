package com.algo0321;
import java.io.*;
import java.util.StringTokenizer;
public class Main_BOJ_16562_친구비 {
    static int N;
    static int[] friendsM;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        friendsM = new int[N+1];
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            friendsM[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int sum = 0;
        for(int i=1; i<=N; i++){
            if(parent[i] == i){
                sum+=friendsM[i];
            }
        }
        if(sum > k){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }
    }
    static int find(int x){
        if(x == parent[x]){
            return parent[x];
        }
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
        if(friendsM[a] < friendsM[b]){
            friendsM[b] = friendsM[a];
        }else{
            friendsM[a] = friendsM[b];
        }
    }
}