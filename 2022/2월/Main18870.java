package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main18870 {
    static int N;
    static int[] arr;
    static int[] answer;
    static int[] sorted;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=0; i<N; i++){
            answer[i] = hashMap.get(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int a : answer){
            sb.append(a+" ");
        }
        System.out.println(sb.toString());
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sorted = new int[N];
        answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }
        Arrays.sort(sorted);
        int rank = 0;
        for(int i=0; i<N; i++){
            if(hashMap.containsKey(sorted[i])) continue;
            hashMap.put(sorted[i], rank);
            rank++;
        }
    }
}
