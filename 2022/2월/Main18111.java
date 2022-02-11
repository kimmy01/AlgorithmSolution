package com.algo2022_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18111 {
    static int N, M, B, min, max, wasteTime, height;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        wasteTime = Integer.MAX_VALUE;
        for(int i=min; i<=max; i++){
            int value = calc(i);
            if(value == -1) continue;
            if(value <= wasteTime){
                wasteTime = value;
                height = i;
            }
        }
        System.out.println(wasteTime+" "+height);
    }
    static int calc(int standard) {
        int time = 0;
        int inventory = B;
        for(int i=0; i<arr.length; i++){
            if(standard > arr[i]){
                int gap = standard - arr[i];
                inventory -= gap;
                time += gap;
            }else if(standard < arr[i]){
                int gap = arr[i] - standard;
                inventory += gap;
                time += gap*2;
            }
        }
        if(inventory >= 0) return time;
        return -1;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        arr = new int[N*M];
        int idx = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                int a = Integer.parseInt(st.nextToken());
                arr[idx] = a;
                if(min > arr[idx]){
                    min = arr[idx];
                }
                if(max < arr[idx]){
                    max = arr[idx];
                }
                idx++;
            }
        }
    }
}
