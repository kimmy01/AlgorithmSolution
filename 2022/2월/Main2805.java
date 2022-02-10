package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main2805 {
    static int N, M, Height;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        System.out.println(binarySearch(1, Height)-1);
    }
    static int binarySearch(int left, int right) {
        while(left < right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int a : arr){
                if(a > mid){
                    sum += a - mid;
                }
            }
            if(sum < M){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        Height = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            Height = Math.max(Height, arr[i]);
        }
    }
}
