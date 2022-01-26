package com.algo2022_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2660 {
    static int N;
    static int[][] relation;
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    static void func() {
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    relation[i][j] = Math.min(relation[i][j], relation[i][k]+relation[k][j]);
                }
            }
        }
        ArrayList<Integer>[] scoreList = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            scoreList[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            int max = -123456789;
            for(int j=1; j<=N; j++){
                if(relation[i][j] != 0){
                    max = Math.max(relation[i][j], max);
                }
            }
            scoreList[max].add(i);
        }
        for(int i=1; i<=N; i++){
            if(!scoreList[i].isEmpty()){
                StringBuilder sb = new StringBuilder();
                sb.append(i+" ");
                sb.append(scoreList[i].size()+"\n");
                for(int j=0; j<scoreList[i].size(); j++){
                    sb.append(scoreList[i].get(j)+" ");
                }
                System.out.println(sb.toString());
                break;
            }
        }
    }
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        relation = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i == j){
                    relation[i][j] = 0;
                    continue;
                }
                relation[i][j] = 123456789;
            }
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1) break;
            relation[a][b] = 1;
            relation[b][a] = 1;
        }
    }
}
