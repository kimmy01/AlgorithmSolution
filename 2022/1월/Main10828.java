package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main10828 {
    static int N;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        func();
    }
    static void func() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command){
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop" : pop(); break;
                case "size" : size(); break;
                case "empty" : empty(); break;
                case "top" : top(); break;
            }
        }
    }
    static void push(int num) {
        stack.push(num);
    }
    static void pop() {
        if(stack.empty()){
            System.out.println(-1);
        }else{
            System.out.println(stack.pop());
        }
    }
    static void size() {
        System.out.println(stack.size());
    }
    static void empty() {
        if(stack.empty()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void top() {
        if(stack.empty()){
            System.out.println(-1);
        }else{
            System.out.println(stack.peek());
        }
    }
}
