package com.algo0323;
import java.util.*;
import java.io.*;
public class Main_BOJ_1149_RGB거리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int R = 0;
        int G = 1;
        int B = 2;
        int[][] RGB = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<3; j++){
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=2; i<=N; i++){
            RGB[i][R] += Math.min(RGB[i-1][G], RGB[i-1][B]);
            RGB[i][G] += Math.min(RGB[i-1][R], RGB[i-1][B]);
            RGB[i][B] += Math.min(RGB[i-1][R], RGB[i-1][G]);
        }
        int answer = Math.min(Math.min(RGB[N][R], RGB[N][G]), RGB[N][B]);
        System.out.println(answer);
    }
}