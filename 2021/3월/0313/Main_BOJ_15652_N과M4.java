package com.algo0313;
import java.util.*;
import java.io.*;
public class Main_BOJ_15652_N과M4 {
    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        selected = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();
        Comb(0, 1);
        System.out.println(sb);
    }
    static void Comb(int cnt, int start){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start; i<=N; i++){
            selected[cnt] = i;
            Comb(cnt+1, i);
            selected[cnt] = 0;
        }
    }
}