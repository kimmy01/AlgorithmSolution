package com.algo0312;
import java.io.*;
import java.util.*;
public class Main_BOJ_15651_N과M3 {
    static int N, M;
    static int[] selected;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        sb = new StringBuilder();
        selected = new int[M];
        Perm(N, M, selected, 0);
        System.out.println(sb.toString());
    }
    static void Perm(int N, int M, int[] selected, int cnt){
        if(cnt == M){
            for(int i=0; i<M; i++){
                sb.append(selected[i]+" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=N; i++){
            selected[cnt] = i;
            Perm(N, M, selected, cnt+1);
            selected[cnt] = 0;
        }
    }
}