package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MinimumAirplane {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int i=0; i<tc; i++){
            String s = br.readLine();
            StringTokenizer stk = new StringTokenizer(s, " ");
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            for(int j=0; j<M; j++){
                s = br.readLine();
            }
            System.out.println(N-1);
        }
    }
}