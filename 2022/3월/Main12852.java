package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main12852 {
    static class Node{
        String s;
        int n;
        int time;
        Node(String s, int n, int time){
            this.s = s;
            this.n = n;
            this.time = time;
        }
    }
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bfs();
    }
    static void bfs(){
        Node start = new Node(new String(), N, 0);
        boolean[] visited = new boolean[N+1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        visited[N] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.n == 1){
                System.out.println(now.time);
                System.out.println(now.s+" "+now.n);
                break;
            }
            if(now.n%3 == 0 && !visited[now.n/3]){
                String tmp;
                if(now.n == N)
                    tmp = String.valueOf(now.n);
                else
                    tmp = now.s + " " + now.n;
                queue.add(new Node(tmp, now.n/3, now.time+1));
                visited[now.n/3] = true;
            }
            if(now.n%2 == 0 && !visited[now.n/2]){
                String tmp;
                if(now.n == N)
                    tmp = String.valueOf(now.n);
                else
                    tmp = now.s + " " + now.n;
                queue.add(new Node(tmp, now.n/2, now.time+1));
                visited[now.n/2] = true;
            }
            if(now.n-1 > 0 && !visited[now.n-1]){
                String tmp;
                if(now.n == N)
                    tmp = String.valueOf(now.n);
                else
                    tmp = now.s + " " + now.n;
                queue.add(new Node(tmp, now.n-1, now.time+1));
                visited[now.n-1] = true;
            }
        }
    }
}
