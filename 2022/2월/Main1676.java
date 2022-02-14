package com.algo2022_02;

import java.io.*;

public class Main1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=1; i<=N; i++){
            int num = i;
            if(num % 5 != 0) {
                continue;
            }
            while(true){
                if(num / 5 == 0) break;
                if(num % 5 == 0) {
                    cnt++;
                    num /= 5;
                }else{
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
