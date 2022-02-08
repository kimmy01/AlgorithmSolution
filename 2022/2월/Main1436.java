package com.algo2022_02;

import java.io.*;

public class Main1436 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int cnt = 0;
        while(cnt < N){
            String tmp = String.valueOf(num);
            if(tmp.contains("666")){
                cnt++;
            }
            num++;
        }
        System.out.println(num-1);
    }
}
