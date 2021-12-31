package com.algo12;

import java.util.*;
import java.io.*;

public class Main17073 {
    static int N, leafCnt;
    static long W;
    static int[] tree;
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    private static void func() {
        for(int i=2; i<=N; i++){
            if(tree[i] == 1){
                leafCnt++;
            }
        }
        System.out.println((double) W/leafCnt);
    }
    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        W = Long.parseLong(st.nextToken());
        tree = new int[N+1];
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            tree[Integer.parseInt(st.nextToken())]++;
            tree[Integer.parseInt(st.nextToken())]++;
        }
    }
}
