package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            int flag = 1;
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String num = br.readLine();
            StringTokenizer st = new StringTokenizer(num.substring(1, num.length()-1), ",");
            Deque<Integer> deque = new LinkedList<>();
            for(int i=0; i<N; i++){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean f = true;
            for(int i=0; i<command.length(); i++){
                char c = command.charAt(i);
                if(c == 'D'){
                    if(deque.isEmpty()){
                        sb.append("error" + "\n");
                        f = false;
                        break;
                    }
                    if(flag == 1){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }
                }else{
                    flag *= -1;
                }
            }
            if(f){
                sb.append("[");
                if(deque.size() == 0){
                    sb.append("]"+"\n");
                    continue;
                }
                if(flag == 1){
                    while(deque.size() > 1){
                        sb.append(deque.pollFirst());
                        sb.append(",");
                    }
                }else{
                    while(deque.size() > 1){
                        sb.append(deque.pollLast());
                        sb.append(",");
                    }
                }
                sb.append(deque.poll()+"]"+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}
