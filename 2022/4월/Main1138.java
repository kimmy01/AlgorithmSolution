package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=N; i>=1; i--){
            list.add(arr[i], i);
        }
        for(int i=0; i<N; i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
