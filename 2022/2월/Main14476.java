package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main14476 {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[N+2];
        int[] right = new int[N+2];
        for(int i=1; i<=N; i++){
            left[i] = gcd(arr[i], left[i-1]);
        }
        for(int i=N; i>0; i--){
            right[i] = gcd(arr[i], right[i+1]);
        }
        int answer = -1;
        int max = -1;
        for(int i=1; i<=N; i++){
            int result = gcd(left[i-1], right[i+1]);
            if(result > max){
                if(arr[i]%result != 0){
                    max = result;
                    answer = arr[i];
                }
            }
        }
        if(answer == -1){
            System.out.println(-1);
        }else{
            System.out.println(max+" "+answer);
        }
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }
}
