package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10830 {
    static int N;
    static long B;
    static long[][] matrix;
    public static void main(String[] args) throws Exception {
        input();
        long[][] answer = func(matrix, B);
        print(answer);
    }
    static long[][] func(long[][] memo, long cnt) {
        if(cnt == 1){ //남은 제곱수가 1일 때 리턴
            return memo;
        }
        long[][] tmp1 = func(memo, cnt/2);
        if(cnt % 2 == 1){ //남은 제곱수가 홀수일 때 cnt = 3
            return calc(calc(tmp1, tmp1), matrix);
        }else{ //cnt = 2
            return calc(tmp1, tmp1);
        }
    }
    static long[][] calc(long[][] A, long[][] B) {
        long[][] response = new long[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                long sum = 0;
                for(int k=0; k<N; k++){
                    sum = (sum + A[i][k]*B[k][j]) % 1000;
                }
                response[i][j] = sum;
            }
        }
        return response;
    }
    static void print(long[][] arr){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]%1000 + " ");
            }
            System.out.println();
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new long[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
