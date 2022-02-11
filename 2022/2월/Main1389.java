package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1389 {
    static int N, M;
    static int[][] relation;
    static int[] value;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        floydWarshall();
        System.out.println(calc());
    }
    static int calc() {
        value = new int[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                value[i] += relation[i][j];
            }
        }
        int min = 123456789;
        int person = 0;
        for(int i=1; i<=N; i++){
            if(min > value[i]){
                person = i;
                min = value[i];
            }
        }
        return person;
    }
    static void floydWarshall() {
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    relation[i][j] = Math.min(relation[i][j], relation[i][k]+relation[k][j]);
                }
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        relation = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j) relation[i][j] = 0;
                else relation[i][j] = 123456789;
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
    }
}
