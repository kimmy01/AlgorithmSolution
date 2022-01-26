package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2138 {
    static int N, max = 123456789;
    static int[] original1;
    static int[] original2;
    static int[] want;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int case1 = making(original1, true);
        int case2 = making(original2, false);
        if(case1 == max && case2 == max){
            System.out.println(-1);
        }else{
            System.out.println(Math.min(case1, case2));
        }
    }
    static int making(int[] arr, boolean flag) {
        int count = 0;
        if(flag){
            arr[0] = 1-arr[0];
            arr[1] = 1-arr[1];
            count++;
        }
        for(int i=1; i<N; i++){
            if(arr[i-1] != want[i-1]){
                arr[i-1] = 1-arr[i-1];
                arr[i] = 1-arr[i];
                count++;
                if(i != N-1){
                    arr[i+1] = 1-arr[i+1];
                }
            }
        }
        if(arr[N-1] != want[N-1]) count = max;
        return count;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        original1 = new int[N];
        original2 = new int[N];
        want = new int[N];
        char[] tmp = br.readLine().toCharArray();
        for(int i=0; i<N; i++){
            original1[i] = tmp[i]-'0' == 0 ? 0 : 1;
            original2[i] = original1[i];
        }
        tmp = br.readLine().toCharArray();
        for(int i=0; i<N; i++){
            want[i] = tmp[i]-'0' == 0 ? 0 : 1;
        }
    }
}
