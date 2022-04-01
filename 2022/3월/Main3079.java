package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main3079 {
    static int N, M;
    static int[] second;
    static long min = 10000000000000000L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        second = new int[N];
        for(int i=0; i<N; i++){
            second[i] = Integer.parseInt(br.readLine());
        }
        func();
        System.out.println(min);
    }
    static void func() {
        long start = 0;
        long end = 1000000000000000000L;
        while(start <= end){
            long mid = (start+end)/2;
            long sum = 0;
            for(int n : second){
                long cnt = mid / n;
                sum += cnt;
                if(sum >= M)
                    break;
            }
            if(sum >= M){
                min = Math.min(min, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
    }
}
