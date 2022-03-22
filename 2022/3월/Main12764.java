package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main12764 {
    static class People{
        int endTime;
        int comNum;
        People(int endTime, int comNum){
            this.endTime = endTime;
            this.comNum = comNum;
        }
    }
    static int N;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<People> pq = new PriorityQueue<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.endTime - o2.endTime;
            }
        });
        int comCnt = 0;
        int[] cnt = new int[100001];
        comCnt++;
        cnt[comCnt]++;
        pq.add(new People(list.get(0)[1], comCnt));
        PriorityQueue<Integer> emptyCom = new PriorityQueue<>();
        for(int i=1; i<list.size(); i++){
            while(!pq.isEmpty()){
                if(pq.peek().endTime > list.get(i)[0]) break;
                People tmp = pq.poll();
                emptyCom.add(tmp.comNum);
            }
            if(emptyCom.isEmpty()){
                comCnt++;
                pq.add(new People(list.get(i)[1], comCnt));
                cnt[comCnt]++;
            }else{
                int tmp = emptyCom.poll();
                pq.add(new People(list.get(i)[1], tmp));
                cnt[tmp]++;
            }
        }
        System.out.println(comCnt);
        for(int i=1; i<=comCnt; i++){
            System.out.print(cnt[i]+" ");
        }
    }
}
