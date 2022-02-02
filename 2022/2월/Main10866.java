package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10866 {
    static Deque<Integer> deque = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int n = 0;
            switch (command){
                case "push_front" :
                    n = Integer.parseInt(st.nextToken());
                    push_front(n); break;
                case "push_back" :
                    n = Integer.parseInt(st.nextToken());
                    push_back(n); break;
                case "pop_front" :
                    pop_front(); break;
                case "pop_back" :
                    pop_back(); break;
                case "size" :
                    size(); break;
                case "empty" :
                    empty(); break;
                case "front" :
                    front(); break;
                case "back" :
                    back(); break;
            }
        }
    }
    static void push_front(int n){
        deque.addFirst(n);
    }
    static void push_back(int n){
        deque.addLast(n);
    }
    static void pop_front(){
        if(deque.isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(deque.pollFirst());
    }
    static void pop_back(){
        if(deque.isEmpty()){
            System.out.println(-1);
            return;
        }
        System.out.println(deque.pollLast());
    }
    static void size(){
        System.out.println(deque.size());
    }
    static void empty(){
        if(deque.isEmpty()){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    static void front(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(deque.peekFirst());
        }
    }
    static void back(){
        if(deque.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(deque.peekLast());
        }
    }
}
