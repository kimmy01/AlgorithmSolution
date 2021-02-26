package com.algo0226;
import java.io.*;
import java.util.*;
public class Main_BOJ_13300_방배정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());
        int room = 0;
        int[] girl = new int[7];
        int[] boy = new int[7];
        for(int i=0; i<N; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(stk.nextToken());
            int grade = Integer.parseInt(stk.nextToken());
            if(sex == 0){
                girl[grade]++;
            }else{
                boy[grade]++;
            }
        }
        for(int i=1; i<=6; i++){
            if(girl[i]%K != 0 && girl[i]>K){
                room+=girl[i]/K+1;
            }else if(girl[i]%K == 0){
                room+=girl[i]/K;
            }else if(girl[i]<K && girl[i]!=0){
                room++;
            }
            if(boy[i]%K != 0 && boy[i]>K){
                room+=boy[i]/K+1;
            }else if(boy[i]%K == 0){
                room+=boy[i]/K;
            }else if(boy[i]<K && boy[i]!=0){
                room++;
            }
        }
        System.out.println(room);
    }
}
