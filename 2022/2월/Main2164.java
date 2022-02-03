package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main2164 {
    static int N;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        while(queue.size() > 1){
            queue.poll();
            int tmp = queue.poll();
            queue.add(tmp);
        }
        System.out.println(queue.poll());
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
    }
}
