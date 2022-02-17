package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main16928 {
    static int N, M;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        input();
        System.out.println(bfs());
    }
    static int bfs() {
        boolean[] visited = new boolean[101];
        visited[1] = true;
        queue.add(1);
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s=0; s<size; s++){
                int now = queue.poll();
                if(now == 100) return count;
                for(int i=1; i<=6; i++){
                    int next = now+i;
                    if(next > 100) break;
                    if(visited[next]) continue;
                    if(map.containsKey(next)){
                        next = map.get(next);
                        if(visited[next]) continue;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
            count++;
        }
        return count;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N+M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}
