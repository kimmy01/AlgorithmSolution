package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(br.readLine());
            arr[n]++;
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0){
                for(int j=0; j<arr[i]; j++){
                    bw.write(String.valueOf(i));
                    bw.newLine();
                }
            }
        }
        bw.flush();
    }
}
