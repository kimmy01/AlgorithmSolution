package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main13397 {
    static int N, M, standard;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        if(M == 1){
            System.out.println(standard);
        }else{
            binarySearch();
        }
    }
    static void binarySearch() {
        int min = 0;
        int mid = 0;
        int answer = 0;
        while(min <= standard) {
            mid = (min + standard) / 2;
            if(divide(mid)){
                answer = mid;
                standard = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        System.out.println(answer);
    }
    static boolean divide(int score) {
        int min = arr[0];
        int max = arr[0];
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(max < arr[i]){
                if(arr[i] - min > score){
                    cnt++;
                    max = arr[i];
                    min = arr[i];
                }else{
                    max = arr[i];
                }
            }
            if(min > arr[i]){
                if(max - arr[i] > score){
                    cnt++;
                    max = arr[i];
                    min = arr[i];
                }else{
                    min = arr[i];
                }
            }
        }
        if(cnt > M) return false;
        return true;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int min = 123456789;
        int max = -123456789;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(min > arr[i]){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        standard = max - min;
    }
}
