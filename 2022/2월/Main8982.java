package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main8982 {
    static int N, K;
    static int[][] point;
    static int[][] water;
    static int[] depth;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        calcDepth();
        for(int i=0; i<water.length; i++){
            changeDepth(water[i][0], water[i][1]);
        }
        calcWater();
    }
    static void calcWater() {
        int sum = 0;
        for(int i=0; i<depth.length; i++){
            sum += depth[i];
        }
        System.out.println(sum);
    }
    static void changeDepth(int start, int end) {
        int minusHeightLeft = depth[start];
        int minusHeightRight = depth[start];
        for(int i=start; i<end; i++){
            depth[i] = 0;
        }
        for(int i=start-1; i>=0; i--){
            if(depth[i] >= minusHeightLeft){
                depth[i] -= minusHeightLeft;
                continue;
            }
            minusHeightLeft = depth[i];
            depth[i] = 0;
        }
        for(int i=end; i<point[N-1][0]; i++){
            if(depth[i] >= minusHeightRight){
                depth[i] -= minusHeightRight;
                continue;
            }
            minusHeightRight = depth[i];
            depth[i] = 0;
        }
    }
    static void calcDepth() {
        depth = new int[point[N-1][0]];
        for(int i=1; i<point.length-1; i+=2){
            int start = point[i][0];
            int end = point[i+1][0];
            int d = point[i][1];
            for(int j=start; j<end; j++){
                depth[j] = d;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        point = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
        water = new int[K][2];
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            water[i][0] = Integer.parseInt(st.nextToken());
            st.nextToken();
            water[i][1] = Integer.parseInt(st.nextToken());
        }
    }
}
