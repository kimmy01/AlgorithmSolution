package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main11509 {
    static int N;
    static int[] balloon;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balloon = new int[1000002];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            balloon[height]++;
            if(balloon[height+1] > 0){
                balloon[height+1]--;
            }else{
                cnt++;
            }
        }
//        int last = 0;
//        int cnt = 0;
//        int balloonCnt = N;
//        while(balloonCnt > 0){
//            for(int i=0; i<N; i++){
//                if(balloon[i] == 0) continue;
//                if(last == 0){
//                   last = balloon[i]-1;
//                   cnt++;
//                   balloonCnt--;
//                   balloon[i] = 0;
//                }else if(last == balloon[i]){
//                    last--;
//                    balloonCnt--;
//                    balloon[i] = 0;
//                }
//                if(last == 0) break;
//            }
//            last = 0;
//        }
        System.out.println(cnt);
    }
}
