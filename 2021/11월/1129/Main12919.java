package com.algo11;

import java.io.*;

public class Main12919 {
    static String S, T;
    static boolean flag;
    static int answer;
    public static void main(String[] args) throws Exception {
        input();
        func(T);
        if(flag){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    private static void func(String next) {
        if(next.length() == S.length()){
            if(S.equals(next)){
                flag = true;
            }
            return;
        }
        if(next.substring(0, 1).equals("B")){
            if(next.substring(next.length()-1).equals("A")) {
                func(next.substring(0, next.length() - 1));
            }
            StringBuffer sb = new StringBuffer(next);
            func(sb.reverse().toString().substring(0, next.length()-1));
        }else{
            if(next.substring(next.length()-1).equals("A")){
                func(next.substring(0, next.length()-1));
            }
        }
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        answer = 0;
        S = br.readLine();
        T = br.readLine();
    }
}
