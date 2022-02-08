package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1874 {
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() throws Exception{
        int idx = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(stack.isEmpty()){
                stack.push(idx);
                idx++;
                sb.append("+"+"\n");
            }
            if(stack.peek() < num){
                if(idx > num) {
                    flag = false;
                    break;
                }
                while(idx <= num){
                    stack.push(idx);
                    sb.append("+"+"\n");
                    idx++;
                }
                stack.pop();
                sb.append("-"+"\n");
            }else if(stack.peek() > num){
                while(true){
                    stack.pop();
                    sb.append("-"+"\n");
                    if(stack.isEmpty() || stack.peek() < num){
                        flag = false;
                        break;
                    }
                    if(stack.peek() == num){
                        stack.pop();
                        sb.append("-"+"\n");
                        break;
                    }
                }
            }else if(stack.peek() == num){
                stack.pop();
                sb.append("-"+"\n");
            }
        }
        if(flag){
            System.out.println(sb.toString());
        }else{
            System.out.println("NO");
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }
    }
}
