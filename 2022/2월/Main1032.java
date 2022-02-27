package com.algo2022_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1032 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i=0; i<N; i++){
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr[0].length(); i++){
            boolean flag = true;
            char c = arr[0].charAt(i);
            for(int j=0; j<N; j++){
                if(arr[j].charAt(i) != c){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append(c);
            }else{
                sb.append('?');
            }
        }
        System.out.println(sb.toString());
    }
}
