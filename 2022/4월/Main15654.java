package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main15654 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        selected = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0, new boolean[N]);
    }
    static void func(int cnt, boolean[] visited) {
        if(cnt == M){
            StringBuilder sb = new StringBuilder();
            for(int n : selected){
                sb.append(n+" ");
            }
            System.out.println(sb.toString());
            return;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[cnt] = arr[i];
                func(cnt+1, visited);
                visited[i] = false;
            }
        }
    }
}
