package com.algo2022_02;

import java.util.*;
import java.io.*;

public class Main22234 {
    static class Client{
        int id;
        int time;
        int arriveTime;
        Client(int id, int time){
            this.id = id;
            this.time = time;
        }
        Client(int id, int time, int arriveTime){
            this.id = id;
            this.time = time;
            this.arriveTime = arriveTime;
        }
        void setTime(int time){
            this.time = time;
        }
    }
    static int N, T, W, M;
    static Queue<Client> jobQueue = new LinkedList<>();
    static ArrayList<Client> waitingList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        int t = 0;
        int ct = 0;
        int idx = 0;
        Client now = jobQueue.poll();
        while(t < W){
            if(idx < M){
                if(waitingList.get(idx).arriveTime == t){
                    jobQueue.add(waitingList.get(idx));
                    idx++;
                }
            }
            if(now.time == ct){
                now = jobQueue.poll();
                ct = 0;
            }else if(now.time > ct && ct == T){
                now.setTime(now.time - ct);
                jobQueue.add(now);
                now = jobQueue.poll();
                ct = 0;
            }
            ct++;
            t++;
            System.out.println(now.id);
        }
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            Client client = new Client(id, time);
            jobQueue.add(client);
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int id = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int arriveTime = Integer.parseInt(st.nextToken());
            Client client = new Client(id, time, arriveTime);
            waitingList.add(client);
        }
        Collections.sort(waitingList, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.arriveTime - o2.arriveTime;
            }
        });
    }
}
