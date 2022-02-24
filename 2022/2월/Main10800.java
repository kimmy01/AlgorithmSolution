package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main10800 {
    static class Ball implements Comparable<Ball>{
        int idx;
        int color;
        int size;
        public Ball(int idx, int color, int size){
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
        @Override
        public int compareTo(Ball o) {
            if(this.size == o.size){
                return this.color - o.color;
            }
            return this.size - o.size;
        }
    }
    static int N, sum;
    static ArrayList<Ball> ballList;
    static int[] answer;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        input();
        func();
    }
    static void func() {
        int lastHap = 0;
        int lastSize = 0;
        int lastColor = 0;
        for(int i=0; i<N; i++){
            Ball b = ballList.get(i);
            if(i>0 && b.size == lastSize){
                if(b.color == lastColor){
                    answer[b.idx] = answer[ballList.get(i-1).idx];
                }else{
                    answer[b.idx] = sum - map.getOrDefault(b.color, 0);
                }
                map.put(b.color, map.getOrDefault(b.color, 0)+b.size);
                lastHap += b.size;
            }else{
                sum += lastHap;
                lastHap = b.size;
                lastSize = b.size;
                answer[b.idx] = sum - map.getOrDefault(b.color, 0);
                map.put(b.color, map.getOrDefault(b.color, 0)+b.size);
            }
            lastColor = b.color;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(answer[i]+"\n");
        }
        System.out.print(sb.toString());
    }
    static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ballList = new ArrayList<>();
        answer = new int[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            ballList.add(new Ball(i, color, size));
        }
        Collections.sort(ballList);
    }
}
