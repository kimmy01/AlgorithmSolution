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
            int start = stoi(stk.nextToken());
            int finish = stoi(stk.nextToken());
            cakeL[i] = finish-start+1;
            maxL = Math.max(cakeL[i], maxL);
            for(int j=start; j<=finish; j++){
                if(!cake[j]){
                    cake[j]=true;
                    people[i]++;
                }
            }
        }
        for(int i=1; i<=N; i++){
            if(realMax < people[i]) {
                realMax = people[i];
            }
        }
        for(int i=1; i<=N; i++){
            if(maxL == cakeL[i]){
                System.out.println(i);
                break;
            }
        }
        for(int i=1; i<=N; i++){
            if(realMax == people[i]){
                System.out.println(i);
                break;
            }
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}