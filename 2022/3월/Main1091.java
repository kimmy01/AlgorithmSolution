package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main1091 {
    static int N;
    static int[] P, S, idx, copy;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];
        idx = new int[N];
        copy = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            P[i] = Integer.parseInt(st.nextToken());
            idx[i] = P[i];
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken());
        }
        func();
    }
    static void func(){
        int count = 0;
        while(isSorted() == false){
            count++;
            for(int i=0; i<N; i++){
                copy[i] = idx[i];
            }
            for(int i=0; i<N; i++){
                idx[S[i]] = copy[i];
            }
            for(int i=0; i<N; i++){
                if(P[i] != idx[i])
                    break;
                if(i == N-1){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
    static boolean isSorted(){
        for(int i=0; i<N; i++){
            if(idx[i] != (i%3))
                return false;
        }
        return true;
    }
}
