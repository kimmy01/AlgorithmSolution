package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2502 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[D];
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<=(D-1); i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        int a = dp[D-2];
        int b = dp[D-1];

        int x = 1;
        int y = 1;
        while(true){
            if(a*x+b*y == K){
                System.out.println(x);
                System.out.println(y);
                break;
            }
            if(a*x+b*y < K){
                x++;
                y++;
            }else{
                y--;
            }
        }
    }
}
