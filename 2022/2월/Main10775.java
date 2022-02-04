package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10775 {
    static int G, P, count;
    static int[] parent;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int n : list){
            int parentN = find(n);
            if(parentN == 0){
                break;
            }
            count++;
            union(parentN, parentN - 1);
        }
        System.out.println(count);
    }
    static int find(int num) {
        if(parent[num] == num) return num;
        return parent[num] = find(parent[num]);
    }
    static void union(int a, int b) {
        int A = find(a);
        int B = find(b);
        if(A < B){
            parent[b] = A;
        }else{
            parent[a] = B;
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        for(int i=0; i<P; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        parent = new int[G+1];
        for(int i=1; i<=G; i++){
            parent[i] = i;
        }
    }
}
