package com.algo0317;
import java.util.*;
import java.io.*;
public class Main_BOJ_14889_스타트와링크 {
    static int N;
    static int[] start;
    static int[] link;
    static int min;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        start = new int[N/2];
        link = new int[N/2];
        min = Integer.MAX_VALUE;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] += a;
                map[j][i] += a;
            }
        }
        Comb(0, 0);
        System.out.println(min);
    }
    static void Comb(int cnt, int st){
        if(cnt == N/2){
            int index = 0;
            for(int i=0; i<N; i++){
                int flag = 0;
                for(int j=0; j<N/2; j++){
                    if(start[j] == i){
                        flag = 1;
                    }
                }
                if(flag == 0){
                    link[index] = i;
                    index++;
                }
            }
            int startHap = 0;
            int linkHap = 0;
            for(int i=0; i<N/2; i++){
                for(int j=i+1; j<N/2; j++){
                    startHap += map[start[i]][start[j]];
                    linkHap += map[link[i]][link[j]];
                }
            }
            min = Math.min(Math.abs(startHap-linkHap), min);
            return;
        }
        for(int i=st; i<N; i++){
            start[cnt] = i;
            Comb(cnt+1, i+1);
        }
    }
}