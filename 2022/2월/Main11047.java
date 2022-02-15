package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11047 {
    static int N, K, idx;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int cnt = 0;
        while(idx >= 0){
            if(K < arr[idx]){
                idx--;
                continue;
            }
            cnt += (K / arr[idx]);
            K = K % arr[idx];
            idx--;
        }
        System.out.println(cnt);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > K){
                continue;
            }
            idx = i;
        }
    }
}
