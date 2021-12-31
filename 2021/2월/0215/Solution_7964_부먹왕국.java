package com.victoria;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7964_부먹왕국 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(stk.nextToken());
            int D = Integer.parseInt(stk.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            stk = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++){
                queue.offer(Integer.parseInt(stk.nextToken()));
            }
            int cities = 0;
            while(!queue.isEmpty()){
                int count = 0;
                if(queue.peek() == 1){
                    queue.poll();
                }
                while(!queue.isEmpty() && queue.peek() != 1){
                    queue.poll();
                    count++;
                }
                cities += count/D;
            }
            System.out.println("#"+t+" "+cities);
        }
    }
}