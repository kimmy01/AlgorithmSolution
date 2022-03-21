package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main17298 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer = new int[N];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
    }
}
