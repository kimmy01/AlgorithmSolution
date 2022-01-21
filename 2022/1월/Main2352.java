package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2352 {
    static int N;
    static int[] arr;
    static int[] L;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int len = 0;
        int idx = 0;
        for(int i=0; i<N; i++){
            if(arr[i] > L[len]){
                len += 1;
                L[len] = arr[i];
            }else{
                idx = binarySearch(0, len, arr[i]);
                L[idx] = arr[i];
            }
        }
        System.out.println(len);
    }
    static int binarySearch(int left, int right, int key){
        int mid = 0;
        while(left < right){
            mid = (left+right)/2;
            if(L[mid] < key){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        L = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
