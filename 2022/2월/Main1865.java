package com.algo2022_02;

import java.util.*;
import java.io.*;

//웜홀 : 시작 위치에서 도착 위치로 가는 하나의 경로, 도착하면 시작했을 때보다 시간이 뒤로 감
//웜홀 내에서는 시간이 거꾸로 감

public class Main1865 {
    static class Road {
        int end;
        int weight;
        public Road(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    static int N, M, W, INF = 123456789;
    static int[] distance;
    static ArrayList<ArrayList<Road>> roadList;
    public static void main(String[] args) throws Exception {
        input();
    }
    static boolean func() {
        Arrays.fill(distance, INF);
        distance[1] = 0;
        boolean flag = false;
        for(int i=1; i<N; i++){
            flag = false;
            for(int j=1; j<=N; j++){
                for(Road road : roadList.get(j)){
                    if(distance[road.end] > distance[j] + road.weight){
                        distance[road.end] = distance[j] + road.weight;
                        flag = true;
                    }
                }
            }
            if(!flag) break;
        }
        if(flag){
            for(int i=1; i<=N; i++){
                for(Road road : roadList.get(i)){
                    if(distance[road.end] > distance[i] + road.weight){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int TC = Integer.parseInt(br.readLine());
        for(int t=0; t<TC; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            distance = new int[N+1];
            roadList = new ArrayList<>();
            for(int i=0; i<=N; i++){
                roadList.add(new ArrayList<>());
            }
            for(int i=0; i<M+W; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                if(i < M){
                    roadList.get(start).add(new Road(end, weight));
                    roadList.get(end).add(new Road(start, weight));
                }else{
                    roadList.get(start).add(new Road(end, -1*weight));
                }
            }
            if(func()){
                bw.write("YES");
                bw.newLine();
            }else{
                bw.write("NO");
                bw.newLine();
            }
        }
        bw.flush();
    }
}
