package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main11265 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
                }
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long t = Long.parseLong(st.nextToken());
            if(map[s][e] <= t){
                sb.append("Enjoy other party").append("\n");
            }else{
                sb.append("Stay here").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
