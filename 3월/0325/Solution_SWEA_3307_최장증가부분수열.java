package com.algo0325;
import java.io.*;
import java.util.*;
public class Solution_SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            int[] LIS = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<N; i++){
                LIS[i] = 1;
                for(int j=0; j<=i-1; j++){
                    if(array[j] < array[i] && LIS[i] < 1+LIS[j]){
                        LIS[i] = 1+LIS[j];
                    }
                }
            }
            Arrays.sort(LIS);
            System.out.println("#"+t+" "+LIS[N-1]);
        }
    }
}