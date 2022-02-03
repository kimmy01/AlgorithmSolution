package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main18427 {
    static int N, M, H;
    static int[][] dp;
    static ArrayList<Integer>[] blockList;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<=N; i++){
            dp[i][0] = 1; //모든 사람이 안쌓는 경우
        }
        for(int i=1; i<=N; i++){ //사람
            for(int j=1; j<=H; j++){ //높이 구간
                for(int k=0; k<blockList[i].size(); k++){ //각 사람 별 블록
                    int n = blockList[i].get(k);
                    if(j >= n){
                        int tmp = dp[i-1][j-n] % 10007; //i번째 사람의 k번째, n높이 블록 쌓는 경우
                        dp[i][j] += tmp;
                    }
                }
                int tmp = dp[i-1][j] % 10007; //i번째 사람이 블록 안쌓는 경우
                dp[i][j] += tmp;
            }
        }
        System.out.println(dp[N][H]%10007);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        blockList = new ArrayList[N+1];
        dp = new int[N+1][H+1];
        for(int i=1; i<=N; i++){
            blockList[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                int tmp = Integer.parseInt(st.nextToken());
                blockList[i].add(tmp);
            }
        }
    }
}
