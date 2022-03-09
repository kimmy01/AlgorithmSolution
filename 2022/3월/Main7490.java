package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main7490 {
    static ArrayList<String> answerList;
    static char[] arr = {'+', '-', ' '};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            answerList = new ArrayList<>();
            func(0, N, new char[N-1]);
            Collections.sort(answerList);
            for(String s : answerList){
                System.out.println(s);
            }
            System.out.println();
        }
    }
    static void func(int cnt, int N, char[] op){
        if(cnt == N-1){
            StringBuilder sb = new StringBuilder();
            Stack<String> stack = new Stack<>();
            sb.append(1);
            stack.push("1");
            for(int i=0; i<N-1; i++){
                sb.append(op[i]);
                sb.append(i+2);
                if(op[i] == '+'){
                    stack.push(String.valueOf(i+2));
                }else if(op[i] == '-'){
                    stack.push(String.valueOf(-1*(i+2)));
                }else{
                    stack.push(stack.pop()+(i+2));
                }
            }
            int num = 0;
            for(String s : stack){
                num += Integer.parseInt(s);
            }
            if(num == 0)
                answerList.add(sb.toString());
            return;
        }
        for(int i=0; i<3; i++){
            op[cnt] = arr[i];
            func(cnt+1, N, op);
            op[cnt] = '0';
        }
    }
}
