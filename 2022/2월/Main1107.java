package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main1107 {
    static int channel, N;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int min = Math.abs(channel - 100);
        for(int i=0; i<=999999; i++){
            boolean flag = true;
            int tmp = i;
            if(i < 10){
                if(set.contains(i)) flag = false;
            }
            while(true){
                if(set.contains(tmp%10)) {
                    flag = false;
                    break;
                }
                tmp = tmp/10;
                if(tmp == 0) break;
            }
            if(flag){
                int len = String.valueOf(i).length();
                min = Math.min(min, Math.abs(channel - i)+len);
            }
        }
        System.out.println(min);
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        channel = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        if(N == 0) return;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
    }
}
