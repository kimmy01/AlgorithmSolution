package com.algo2022_02;

import java.util.*;
import java.io.*;

//몇몇 역에 소형 기관차 3대 배치 (평소 이용하는 기관차보다 훨씬 적은 수의 객차만 끌 수 있음)
//소형 기관차가 최대로 끌 수 있는 객차의 수 미리 정함, 그보다 더 많은 수의 객차 절대로 끌 수 없음.
//3대의 소형 기관차가 최대로 끌 수 있는 객차의 수 같음
//소형 기관차 3대를 이용해서 최대한 많은 손님을 목적지까지 운송, 각 객차마다 타고 있는 손님의 수 미리 알고, 다른 객차고 손님들이 이동하는 것 허용X
//소형 기관차, 번호가 연속적으로 이어진 객차 끌게 함. 기관차 바로 뒤에 있는 객차부터 시작, 1번부터 차례 번호

public class Main2616 {
    static int N, M, answer;
    static int[] train;
    static int[] hap;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        calc();
        dp();
        System.out.println(answer);
    }
    static void dp() {
        dp = new int[4][N+1];
        for(int i=1; i<=3; i++){
            for(int j=1; j<=N; j++){
                dp[i][j] = 0;
                if(j - M >= 0){
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-M]+(hap[j]-hap[j-M]));
                }
                answer = Math.max(dp[i][j], answer);
            }
        }
    }
    static void calc() {
        hap = new int[N+1];
        for(int i=0; i<N; i++){
            hap[i+1] = hap[i] + train[i];
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        train = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            train[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
    }
}
