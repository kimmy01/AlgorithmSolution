package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main8983 {
    static int N, M, L, answer;
    static int[] gun;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        gun = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<M; i++){
            gun[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(gun);
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean flag = func(x, y);
            if(flag) answer++;
        }
        System.out.println(answer);
    }
    static boolean func(int x, int y){
        int start = 0;
        int end = M;
        while(start < end){
            int mid = (start+end)/2;
            int dis = calc(x, y, gun[mid]);
            if(dis <= L) return true;
            if(gun[mid] < x){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return false;
    }
    static int calc(int x, int y, int gun){
        return Math.abs(gun - x) + y;
    }
}
