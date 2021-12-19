package com.algo12;

import java.util.*;
import java.io.*;

public class Main2098 {
    static int[][] map;
    static int[][] dp;
    static int N;
    static int INF = Integer.MAX_VALUE - 1000000;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][1<<16];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    static void func(){
        System.out.println(tsp(0, 1));
    }
    static int tsp(int current, int visited){
        //모든 곳 방문했을 때
        if(visited == (1<<N)-1){
            if(map[current][0] == 0){ //돌아가는 방법 없으면
                return INF;
            }
            return map[current][0]; //돌아가는 방법 있으면
        }
        //이미 방문했을 때
        if(dp[current][visited] != 0){
            return dp[current][visited];
        }
        dp[current][visited] = INF;
        for(int k=0; k<N; k++){
            int next = 1<<k;
            if(map[current][k] == 0 || (visited & next) > 0){ //갈 수 없거나 이미 방문함
                continue;
            }
            //current에서 visited만큼 방문했을 때, 도시 전체 순회 최소 비용
            dp[current][visited] = Math.min(dp[current][visited], tsp(k, visited|next) + map[current][k]);
        }
        return dp[current][visited];
    }
}
