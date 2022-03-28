package com.algo2022_03;

import java.io.*;
import java.util.*;


public class Main1965 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }
        int[] result = new int[max+1];
        for(int i=0; i<N; i++){
            if(i == 0){
                result[arr[i]] = 1;
                continue;
            }
            int tmp = 0;
            for(int j=0; j<arr[i]; j++){
                tmp = Math.max(result[j], tmp);
            }
            result[arr[i]] = tmp+1;
        }
        Arrays.sort(result);
        System.out.println(result[max]);
    }
}
