package com.algo0314;
import java.util.*;
import java.io.*;
public class Main_BOJ_9184_신나는함수실행 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            if(a==-1 && b==-1 && c==-1) break;
            sb.append("w("+a+", "+b+", "+c+") = ").append(w(a, b, c)).append('\n');
        }
        System.out.println(sb);
    }

    static int w(int a, int b, int c){
        if(inRange(a, b, c) && dp[a][b][c]!=0){
            return dp[a][b][c];
        }
        if(a<=0 || b<=0 || c<=0){
            return 1;
        }
        if(a>20 || b>20 || c>20){
            return dp[20][20][20] = w(20, 20, 20);
        }
        if(a<b && b<c){
            return dp[a][b][c] = w(a, b, c-1)+w(a, b-1, c-1)-w(a, b-1, c);
        }
        return dp[a][b][c] = w(a-1, b, c)+w(a-1, b-1, c)+w(a-1, b, c-1)-w(a-1, b-1, c-1);
    }
    static boolean inRange(int a, int b, int c){
        return 0<=a && a<=20 && 0<=b && b<=20 && 0<=c && c<=20;
    }
}