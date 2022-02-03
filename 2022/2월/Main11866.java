package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main11866 {
    static int N, K;
    static ArrayList<Integer> list = new ArrayList<>();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int cnt = 1;
        while(queue.size() > 1){
            if(cnt == K){
                list.add(queue.poll());
                cnt = 1;
            }else{
                int a = queue.poll();
                queue.add(a);
                cnt++;
            }
        }
        list.add(queue.poll());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i=0; i<N; i++){
            sb.append(list.get(i));
            if(i == N-1) continue;
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
    }
}
