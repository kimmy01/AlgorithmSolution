package com.algo0312;
import java.util.*;
import java.io.*;
public class Main_BOJ_15650_N과M2 {
    static int N, M;
    static int[] selected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        selected = new int[M];
        Comb(0, 1);
    }
    static void Comb(int cnt, int start){
        if(cnt == M){
            Arrays.sort(selected);
            for(int i=0; i<M; i++){
                System.out.print(selected[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=start; i<=N; i++){
            selected[cnt] = i;
            Comb(cnt+1, i+1);
        }
    }
}
