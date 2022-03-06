package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2342 {
    static int[][][] dp;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while(true){
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            list.add(n);
        }
        dp = new int[list.size()][5][5];
        System.out.println(dfs(0, 0, 0));
    }
    static int dfs(int idx, int left, int right){
        if(idx == list.size()) return 0;
        if(dp[idx][left][right] != 0) return dp[idx][left][right];
        int goLeft = dfs(idx+1, list.get(idx), right) + go(left, list.get(idx));
        int goRight = dfs(idx+1, left, list.get(idx)) + go(right, list.get(idx));
        dp[idx][left][right] = Math.min(goLeft, goRight);
        return dp[idx][left][right];
    }
    static int go(int start, int end){
        if(start == 0) return 2;
        else if(Math.abs(start - end) == 2) return 4;
        else if(start == end) return 1;
        else return 3;
    }
}
