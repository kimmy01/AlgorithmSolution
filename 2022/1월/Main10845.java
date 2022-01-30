package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main10845 {
    static int N;
    static Deque<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        func();
    }
    static void func() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    pop(); break;
                case "size":
                    size(); break;
                case "empty":
                    empty(); break;
                case "front":
                    front(); break;
                case "back":
                    back(); break;
            }
        }
    }
    static void push(int num) {
        queue.addLast(num);
    }
    static void pop() {
        if(queue.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(queue.pollFirst());
        }
    }
    static void size() {
        System.out.println(queue.size());
    }
    static void empty() {
        if(queue.isEmpty()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void front() {
        if(queue.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(queue.peekFirst());
        }
    }
    static void back() {
        if(queue.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(queue.peekLast());
        }
    }
}
