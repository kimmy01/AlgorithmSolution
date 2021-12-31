package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main9012 {
    static int N;
    static String[] strings;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(check(strings[i])+"\n");
        }
        System.out.println(sb.toString());
    }
    static String check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return "NO";
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty()) return "YES";
        return "NO";
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strings = new String[N];
        for(int i=0; i<N; i++){
            strings[i] = br.readLine();
        }
    }
}
