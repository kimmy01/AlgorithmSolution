package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1756 {
    static int D, N, min, end;
    static int[] oven;
    static int[] pizza;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        oven = new int[D];
        pizza = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<D; i++){
            oven[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            pizza[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        for(int i=0; i<D; i++){
            if(oven[i] < min){
                min = oven[i];
            }else{
                oven[i] = min;
            }
        }
        end = D-1;
        min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            binarySearch(pizza[i], 0, end);
        }
        min++;
        System.out.println(min);
    }
    static void binarySearch(int pizza, int s, int e){
        int result = -1;
        while(s <= e){
            int mid = (s+e)/2;
            if(oven[mid] >= pizza){
                result = mid;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        min = Math.min(min, result);
        end = result-1;
    }
}
