package com.algo2022_02;

import java.io.*;

public class Main5582 {
    static int n, m, max;
    static char[] string1 = new char[4001];
    static char[] string2 = new char[4001];
    static int[][] dp = new int[4001][4001];
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(string1[i-1] == string2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        string1 = br.readLine().toCharArray();
        string2 = br.readLine().toCharArray();
        n = string1.length;
        m = string2.length;
        max = 0;
    }
}
