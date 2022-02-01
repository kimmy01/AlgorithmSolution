package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main1978 {
    static int N, count;
    static int[] arr;
    static boolean[] primeNum;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        checkPrime();
        for(int n : arr){
            if(primeNum[n]){
                count++;
            }
        }
        System.out.println(count);
    }
    static void checkPrime() {
        primeNum[0] = false;
        primeNum[1] = false;
        for(int i=2; i<=1000; i++){
            for(int j=i+i; j<=1000; j+=i){
                primeNum[j] = false;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        primeNum = new boolean[1001];
        Arrays.fill(primeNum, true);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
