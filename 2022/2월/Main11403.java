package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11403 {
    static int N;
    static int[][] relation;
    public static void main(String[] args) throws Exception {
        input();
        floydWarshall();
    }
    static void floydWarshall() {
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    relation[i][j] = Math.min(relation[i][j], relation[i][k]+relation[k][j]);
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int answer = 0;
                if(relation[i][j] == 123456789){
                    answer = 0;
                }else{
                    answer = 1;
                }
                System.out.print(answer);
                if(j == N-1) continue;
                System.out.print(" ");
            }
            if(i == N-1) continue;
            System.out.println();
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        relation = new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                relation[i][j] = 123456789;
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    relation[i][j] = tmp;
                }
            }
        }
    }
}
