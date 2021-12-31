package com.algo0615;

import java.io.*;
import java.util.*;

public class Main_BOJ_사이클게임 {
    static int n, m;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        //선 - 홀수, 후 - 짝수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        boolean flag = false;
        for(int i=0; i<m; i++){
            print();
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int parentA = find(a);
            int parentB = find(b);
            if(parentA == parentB) {
                System.out.println(i+1); flag = true; break;
            }
            union(a, b);
        }
        if(!flag){
            System.out.println(0);
        }
    }
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x == y) return;
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
    static Integer find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void print(){
        for(int i=0; i<parent.length; i++){
            System.out.print(parent[i]+" ");
        }
        System.out.println();
    }
}
