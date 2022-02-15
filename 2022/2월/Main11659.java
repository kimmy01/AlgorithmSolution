package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11659 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            arr[i] += arr[i-1];
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(String.valueOf(arr[end] - arr[start-1]));
            bw.newLine();
        }
        bw.flush();
    }
}
