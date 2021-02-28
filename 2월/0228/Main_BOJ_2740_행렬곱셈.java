package com.algo02280301;

import java.io.*;
import java.util.*;

public class Main_BOJ_2740_행렬곱셈 {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        N = stoi(stk.nextToken());
        int M = stoi(stk.nextToken());
        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                A[i][j] = stoi(stk.nextToken());
            }
        }
        stk = new StringTokenizer(br.readLine(), " ");
        stk.nextToken();
        K = stoi(stk.nextToken());
        int[][] B = new int[M][K];
        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < K; j++) {
                B[i][j] = stoi(stk.nextToken());
            }
        }

        Queue<Integer> answer = new LinkedList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int sum = 0;
                for(int a=0; a<M; a++) {
                    sum += A[i][a] * B[a][j];
                }
                answer.offer(sum);
            }
        }

        print(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
    static void print(Queue<Integer> queue){
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                System.out.print(queue.poll()+" ");
            }
            System.out.println();
        }
    }
}
