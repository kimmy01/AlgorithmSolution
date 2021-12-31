package com.algo12;

import java.io.*;

public class Main1094 {
    static int X;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int hap = 64;
        int cnt = 1;
        int stick = 64;
        while(true){
            if(hap > X){
                int tmp = stick/2;
                if((hap - tmp) > X){
                    hap -= tmp;
                    stick = tmp;
                }else if((hap - tmp) == X){
                    System.out.println(cnt);
                    break;
                }else{
                    stick = tmp;
                    cnt++;
                }
            }else{
                System.out.println(cnt);
                break;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
    }
}
