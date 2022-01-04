package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main20154 {
    static String s;
    static Queue<Integer> queue = new LinkedList<>();
    static int[] alphabet = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        Queue<Integer> tmp;
        while(true){
            tmp = new LinkedList<>();
            while(queue.size() >= 2){
                int a = queue.poll();
                int b = queue.poll();
                if(a+b > 10){
                    tmp.add((a+b)%10);
                    continue;
                }
                tmp.add(a+b);
            }
            if(!queue.isEmpty()) tmp.add(queue.poll());
            queue = tmp;
            if(queue.size() == 1) {
                int result = queue.poll();
                if(result % 2 == 0){
                    System.out.println("You're the winner?");
                }else{
                    System.out.println("I'm a winner!");
                }
                return;
            }
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            queue.add(alphabet[c-'A']);
        }
    }
}
