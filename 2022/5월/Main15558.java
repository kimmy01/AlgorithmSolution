package com.algo2022_05;

import java.io.*;
import java.util.*;

public class Main15558 {
    static class Node {
        int now;
        String dir;
        Node(int now, String dir){
            this.now = now;
            this.dir = dir;
        }
    }
    static int N, K;
    static int[] leftLine, rightLine;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        leftLine = new int[N+1];
        rightLine = new int[N+1];
        String left = br.readLine();
        String right = br.readLine();
        for(int i=1; i<=N; i++){
            leftLine[i] = left.charAt(i-1) - '0';
            rightLine[i] = right.charAt(i-1) - '0';
        }
        func();
    }
    static void func() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, "left"));
        int time = 0;
        boolean[] visitedLeft = new boolean[N+K];
        boolean[] visitedRight = new boolean[N+K];
        visitedLeft[1] = true;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                Node node = queue.poll();
                if(node.now > N){
                    System.out.println(1);
                    return;
                }
                if(node.dir == "left"){
                    if(time+1 < node.now-1 && node.now-1 > 0 && leftLine[node.now-1] == 1 && !visitedLeft[node.now-1]){
                        queue.add(new Node(node.now-1, "left"));
                        visitedLeft[node.now-1] = true;
                    }
                    if(node.now+1 <= N && leftLine[node.now+1] == 1 && !visitedLeft[node.now+1]){
                        queue.add(new Node(node.now+1, "left"));
                        visitedLeft[node.now+1] = true;
                    }
                    if(node.now+K <= N && rightLine[node.now+K] == 1 && !visitedRight[node.now+K]){
                        queue.add(new Node(node.now+K, "right"));
                        visitedRight[node.now+K] = true;
                    }
                    if(node.now+1 > N){
                        queue.add(new Node(node.now+1, "left"));
                    }
                    if(node.now+K > N){
                        queue.add(new Node(node.now+K, "right"));
                    }
                }else{
                    if(time+1 < node.now-1 && node.now-1 > 0 && rightLine[node.now-1] == 1 && !visitedRight[node.now-1]){
                        queue.add(new Node(node.now-1, "right"));
                        visitedRight[node.now-1] = true;
                    }
                    if(node.now+1 <= N && rightLine[node.now+1] == 1 && !visitedRight[node.now+1]){
                        queue.add(new Node(node.now+1, "right"));
                        visitedRight[node.now+1] = true;
                    }
                    if(node.now+K <= N && leftLine[node.now+K] == 1 && !visitedLeft[node.now+K]){
                        queue.add(new Node(node.now+K, "left"));
                        visitedLeft[node.now+K] = true;
                    }
                    if(node.now+1 > N){
                        queue.add(new Node(node.now+1, "right"));
                    }
                    if(node.now+K > N){
                        queue.add(new Node(node.now+K, "left"));
                    }
                }
            }
            time++;
        }
        System.out.println(0);
    }
}
