package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main1106 {
    static class City{
        int cost;
        int person;
        City(int cost, int person){
            this.cost = cost;
            this.person = person;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        City[] list = new City[N];
        int[] dp = new int[C+1];
        Arrays.fill(dp, 123456789);
        dp[0] = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            list[i] = new City(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<C; i++){
            if(dp[i] == 123456789) continue;
            for(int j=0; j<N; j++){
                int next = Math.min(i+list[j].person, C);
                dp[next] = Math.min(dp[next], dp[i]+list[j].cost);
            }
        }
        System.out.println(dp[C]);
    }
}
