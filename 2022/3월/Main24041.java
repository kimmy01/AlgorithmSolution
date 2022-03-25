package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main24041 {
    static class Food implements Comparable<Food> {
        int S;
        int L;
        int O;
        long Bacteria;
        Food(int S, int L, int O, long Bacteria){
            this.S = S;
            this.L = L;
            this.O = O;
            this.Bacteria = Bacteria;
        }
        void setBacteria(long Bacteria){
            this.Bacteria = Bacteria;
        }
        @Override
        public int compareTo(Food o) {
            return Long.compare(o.Bacteria, this.Bacteria);
        }
    }
    static int N, G, K;
    static ArrayList<Food> foodList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            foodList.add(new Food(s, l, o, 0L));
        }
        func();
    }
    static void func() {
        long start = 0;
        long end = 2L *(int)Math.pow(10, 9);
        long mid = 0;
        long answer = 0;
        while(start <= end){
            mid = (start+end)/2;
            long bacteria = calc(mid);
            if(bacteria <= G){
                answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
    static long calc(long day){
        for(int i=0; i<N; i++){
            int s = foodList.get(i).S;
            int l = foodList.get(i).L;
            long bacteria = s*Math.max(1, day-l);
            foodList.get(i).setBacteria(bacteria);
        }
        Collections.sort(foodList);
        long cnt = 0;
        long hap = 0;
        for(int i=0; i<N; i++){
            if(foodList.get(i).O == 1 && cnt < K)
                cnt++;
            else
                hap += foodList.get(i).Bacteria;
        }
        return hap;
    }
}
