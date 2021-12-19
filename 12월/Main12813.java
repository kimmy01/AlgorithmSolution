package com.algo12;

import java.io.*;

public class Main12813 {
    static String A, B;
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
    }
    static void func(){
        and(A, B);
        or(A, B);
        xor(A, B);
        not(A);
        not(B);
    }
    static void and(String A, String B){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == B.charAt(i)){
                sb.append(A.charAt(i));
            }else{
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
    }
    static void or(String A, String B){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)-'0' == 1 || B.charAt(i)-'0' == 1){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }
        System.out.println(sb.toString());
    }
    static void xor(String A, String B){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == B.charAt(i)){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        System.out.println(sb.toString());
    }
    static void not(String S){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)-'0' == 1){
                sb.append(0);
            }else{
                sb.append(1);
            }
        }
        System.out.println(sb.toString());
    }
}
