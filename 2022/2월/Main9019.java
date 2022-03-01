package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main9019 {
    static class DSLR{
        int num;
        String command;
        DSLR(int num, String command){
            this.num = num;
            this.command = command;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String s = br.readLine();
            int A = Integer.parseInt(s.split(" ")[0]);
            int B = Integer.parseInt(s.split(" ")[1]);
            System.out.println(func(A, B));
        }
    }
    static String func(int A, int B) {
        String answer = new String();
        DSLR dslr = new DSLR(A, "");
        Queue<DSLR> queue = new LinkedList<>();
        queue.add(dslr);
        boolean[] visited = new boolean[10001];
        while(!queue.isEmpty()){
            DSLR now = queue.poll();
            if(now.num == B) {
                answer = now.command;
                break;
            }
            //D
            int next = now.num*2 % 10000;
            if(!visited[next]){
                queue.add(new DSLR(now.num*2 % 10000, now.command+"D"));
                visited[next] = true;
            }
            //S
            if(now.num == 0) next = 9999;
            else next = now.num - 1;
            if(!visited[next]){
                queue.add(new DSLR(next, now.command+"S"));
            }
            //L
            String nowNum = String.valueOf(now.num);
            while(nowNum.length() < 4){
                nowNum = "0"+nowNum;
            }
            char[] arr = nowNum.toCharArray();
            char tmp = arr[0];
            for(int i=0; i<3; i++){
                arr[i] = arr[i+1];
            }
            arr[3] = tmp;
            next = Integer.parseInt(new String(arr));
            if(!visited[next]){
                queue.add(new DSLR(next, now.command+"L"));
                visited[next] = true;
            }
            //R
            arr = nowNum.toCharArray();
            tmp = arr[3];
            for(int i=3; i>=1; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = tmp;
            next = Integer.parseInt(new String(arr));
            if(!visited[next]){
                queue.add(new DSLR(next, now.command+"R"));
                visited[next] = true;
            }
        }
        return answer;
    }
}
