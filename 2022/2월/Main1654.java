package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1654 {
    static int K, N, len;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        binarySearch(1, len);
    }
    static void binarySearch(long left, long right) {
        while(left <= right) {
            long mid = (left+right)/2;
            long sum = 0;
            for(int lan : arr){
                sum += (lan/mid);
            }
            if(sum < N){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(right);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        len = 0;
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
            len = Math.max(arr[i], len);
        }
    }
}
