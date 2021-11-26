package com.algo11;

import java.io.*;
import java.util.*;

public class Main1920 {
    static int N, M, start, end;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
    private static void func() {
        Arrays.sort(A);
        for(int n : B){
            if(binarySearch(A, n) == 1) {
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
    private static int binarySearch(int[] arr, int key) {
        start = 0;
        end = N-1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(key < A[mid]){
                end = mid-1;
            }else if(key > A[mid]){
                start = mid+1;
            }else{
                return 1;
            }
        }
        return -1;
    }
}
