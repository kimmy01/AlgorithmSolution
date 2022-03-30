package com.algo2022_03;

import java.io.*;

public class Main2302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] vip = new int[M];
        for(int i=0; i<M; i++){
            vip[i] = Integer.parseInt(br.readLine());
        }
        int[] result = new int[41];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        for(int i=3; i<=40; i++){
            result[i] = result[i-1] + result[i-2];
        }
        int answer = 1;
        int last = 0;
        for(int i=0; i<vip.length; i++){
            answer *= result[vip[i] - last - 1];
            last = vip[i];
        }
        answer *= result[N - last];
        System.out.println(answer);
    }
}
