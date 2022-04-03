package com.algo2022_04;

import java.io.*;
import java.util.*;

public class Main5014 {
    static int F, S, G, U, D;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        func();
    }
    static void func(){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[F+1];
        queue.add(new int[]{S, 0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == G){
                System.out.println(now[1]);
                return;
            }
            int upNext = now[0] + U;
            int downNext = now[0] - D;
            if(upNext <= F && !visited[upNext]){
                visited[upNext] = true;
                queue.add(new int[]{upNext, now[1]+1});
            }
            if(downNext >= 1 && !visited[downNext]){
                visited[downNext] = true;
                queue.add(new int[]{downNext, now[1]+1});
            }
        }
        System.out.println("use the stairs");
        return;
    }
}
