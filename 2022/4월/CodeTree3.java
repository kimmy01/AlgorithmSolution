package com.algo2022_04;

import java.util.*;
import java.io.*;

public class CodeTree3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] map = new int[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=M; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n == 1)
                    map[i]++;
            }
        }
        for(int i=0; i<2; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j=start; j<=end; j++){
                if(map[j] > 0)
                    map[j]--;
            }
        }
        int answer = 0;
        for(int i=0; i<=N; i++){
            answer += map[i];
        }
        System.out.println(answer);
    }
}
