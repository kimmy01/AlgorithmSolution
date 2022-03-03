package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main12851 {
    static class HideAndSeek{
        int time;
        int location;
        HideAndSeek(int time, int location){
            this.time = time;
            this.location = location;
        }
    }
    static int N, K, minTime, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        N = Integer.parseInt(s.split(" ")[0]);
        K = Integer.parseInt(s.split(" ")[1]);
        bfs();
        System.out.println(minTime);
        System.out.println(answer);
    }
    static void bfs(){
        HideAndSeek first = new HideAndSeek(0, N);
        boolean[] visited = new boolean[100001];
        Queue<HideAndSeek> queue = new LinkedList<>();
        queue.add(first);
        while(!queue.isEmpty()){
            int turn = queue.size();
            while(turn-- > 0){
                visited[K] = false;
                HideAndSeek now = queue.poll();
                visited[now.location] = true;
                if(now.location == K){
                    if(minTime == 0) minTime = now.time;
                    if(minTime == now.time){
                        answer++;
                        continue;
                    }
                }
                if(now.location+1 <= 100000 && !visited[now.location+1]){
                    queue.add(new HideAndSeek(now.time+1, now.location+1));
                }
                if(now.location-1 >= 0 && !visited[now.location-1]){
                    queue.add(new HideAndSeek(now.time+1, now.location-1));
                }
                if(now.location*2 <= 100000 && !visited[now.location*2]){
                    queue.add(new HideAndSeek(now.time+1, now.location*2));
                }
            }
        }
    }
}
