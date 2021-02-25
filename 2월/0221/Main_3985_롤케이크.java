package com.algo02200221;

import java.io.*;
import java.util.StringTokenizer;

public class Main_3985_롤케이크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = stoi(br.readLine());
        int N = stoi(br.readLine());
        int maxL = Integer.MIN_VALUE;
        int realMax = Integer.MIN_VALUE;
        int[] cakeL = new int[N+1]; //원하는 조각
        boolean[] cake = new boolean[L+1]; //케이크
        int[] people = new int[N+1]; //실제 조각
        for(int i=1; i<=N; i++){
            String temp = br.readLine();
            StringTokenizer stk = new StringTokenizer(temp, " ");
            int start = Integer.parseInt(stk.nextToken()); //케이크 시작
            int finish = Integer.parseInt(stk.nextToken()); //케이크 끝
            cakeL[i] = finish-start+1; //케이크 길이
            maxL = Math.max(cakeL[i], maxL); //제일 긴 케이크 원하는 크기
            for(int j=start; j<=finish; j++){
                if(!cake[j]){ //케이크가 남아있다면
                    cake[j]=true; 
                    people[i]++; //가져가기
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(realMax < people[i]) { //제일 많은 케이크 크기 찾기
                realMax = people[i];
            }
        }
        for(int i=1; i<=N; i++){ //가장 많은 케이크 기대하는 방청객 번호
            if(maxL == cakeL[i]){
                System.out.println(i);
                break;
            }
        }
        for(int i=1; i<=N; i++){ //실제로 가장 많은 케이크 받은 방청객 번호
            if(realMax == people[i]){
                System.out.println(i);
                break;
            }
        }
    }
}