package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main1697 {
    static int N, K, INF = 100000;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        System.out.println(bfs());
    }
    static int bfs() {
        boolean[] visited = new boolean[INF+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                int now = queue.poll();
                if(now == K) return time;
                if(0 <= now+1 && now+1 <=INF && !visited[now+1]) {
                    queue.add(now+1);
                    visited[now+1] = true;
                }
                if(0 <= now-1 && now-1 <= INF && !visited[now-1]) {
                    queue.add(now-1);
                    visited[now-1] = true;
                }
                if(0 <= now*2 && now*2 <= INF && !visited[now*2]) {
                    queue.add(now*2);
                    visited[now*2] = true;
                }
            }
            time++;
        }
        return time;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}
