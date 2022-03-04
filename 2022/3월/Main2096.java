package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2096 {
    static int N;
    static int[] d = {-1, 0, 1};
    static int[][] arr1, arr2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr1 = new int[N][3];
        arr2 = new int[N][3];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr1[i][0] = arr2[i][0] = Integer.parseInt(st.nextToken());
            arr1[i][1] = arr2[i][1] = Integer.parseInt(st.nextToken());
            arr1[i][2] = arr2[i][2] = Integer.parseInt(st.nextToken());
        }
        System.out.print(maxFunc(arr2)+" "+minFunc(arr1));
    }
    static int maxFunc(int[][] arr){
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                int max = 0;
                for(int k=0; k<3; k++){
                    int a = j+d[k];
                    if(0<=a && a<3) max = Math.max(max, arr[i-1][a]+arr[i][j]);
                }
                arr[i][j] = max;
            }
        }
        Arrays.sort(arr[N-1]);
        return arr[N-1][2];
    }
    static int minFunc(int[][] arr){
        for(int i=1; i<N; i++){
            for(int j=0; j<3; j++){
                int min = 123456789;
                for(int k=0; k<3; k++){
                    int a = j+d[k];
                    if(0<=a && a<3) min = Math.min(min, arr[i-1][a]+arr[i][j]);
                }
                arr[i][j] = min;
            }
        }
        Arrays.sort(arr[N-1]);
        return arr[N-1][0];
    }
}
