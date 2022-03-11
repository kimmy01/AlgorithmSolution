package com.algo2022_03;

import java.io.*;
import java.util.*;

public class Main2461 {
    static int N, M;
    static int[] count;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                list.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        System.out.println(func());
    }
    static int func() {
        int l = 0;
        int r = 0;
        int dif = Integer.MAX_VALUE;
        while(l < N*M-1 && r < N*M-1){
            while(r < N*M-1){
                count[list.get(r++)[0]]++;
                if(check()) break;
            }
            while(count[list.get(l)[0]] > 1){
                count[list.get(l++)[0]]--;
            }
            if(check()){
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int i=l; i<r; i++){
                    min = Math.min(min, list.get(i)[1]);
                    max = Math.max(max, list.get(i)[1]);
                }
                dif = Math.min(dif, max-min);
            }
            count[list.get(l++)[0]]--;
        }
        return dif;
    }
    static boolean check() {
        for(int cnt : count){
            if(cnt == 0) return false;
        }
        return true;
    }
}