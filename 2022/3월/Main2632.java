package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main2632 {
    static int N, m, n;
    static long answer;
    static boolean[] check;
    static int[] pizzaA, pizzaB;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
//    static ArrayList<Integer> AList = new ArrayList<>();
//    static ArrayList<Integer> BList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        pizzaA = new int[m];
        pizzaB = new int[n];
        hashMap.put(0, 1);
//        AList.add(0);
//        BList.add(0);
        for(int i=0; i<m; i++){
            pizzaA[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            pizzaB[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<m; i++){
            check = new boolean[m];
            check[i] = true;
//            func(pizzaA[i], i, i+1, check, pizzaA, AList);
            func(pizzaA[i], i, i+1, check, pizzaA);
        }
        for(int i=0; i<n; i++){
            check = new boolean[n];
            check[i] = true;
//            func(pizzaB[i], i, i+1, check, pizzaB, BList);
            solve(pizzaB[i], i, i+1, check, pizzaB);
        }
        answer += hashMap.getOrDefault(N, 0);
        System.out.println(answer);
    }
//    static void func(int sum, int startIdx, int idx, boolean[] check, int[] pizza, ArrayList list) {
//        if(idx == pizza.length) idx = 0;
//        list.add(sum);
//        if(check[idx] == false && idx != startIdx-1 && sum <= N){
//            check[idx] = true;
//            func(sum+pizza[idx], startIdx, idx+1, check, pizza, list);
//        }else{
//            return;
//        }
//    }
    static void func(int sum, int startIdx, int idx, boolean[] check, int[] pizza) {
        if(idx == pizza.length) idx = 0;
        hashMap.put(sum, hashMap.getOrDefault(sum, 0)+1);
        if(check[idx] == false && idx != startIdx-1 && sum <= N){
            check[idx] = true;
            func(sum+pizza[idx], startIdx, idx+1, check, pizza);
        }else{
            return;
        }
    }
    static void solve(int sum, int startIdx, int idx, boolean[] check, int[] pizza){
        if(idx == pizza.length) idx = 0;
        answer += hashMap.getOrDefault(N-sum, 0);
        if(check[idx] == false && idx != startIdx-1 && sum <= N){
            check[idx] = true;
            solve(sum+pizza[idx], startIdx, idx+1, check, pizza);
        }else return;
    }
//    static long solve(){
//        long answer = 0;
//        int leftIdx = 0;
//        int rightIdx = BList.size() - 1;
//        while(leftIdx < AList.size() && 0 <= rightIdx){
//            int l = AList.get(leftIdx);
//            int r = BList.get(rightIdx);
//            if(l+r == N){
//                int lcnt = 0;
//                while(leftIdx < AList.size() && AList.get(leftIdx) == l){
//                    lcnt++;
//                    leftIdx++;
//                }
//                int rcnt = 0;
//                while(rightIdx >= 0 && BList.get(rightIdx) == r){
//                    rcnt++;
//                    rightIdx--;
//                }
//                answer += lcnt*rcnt;
//            }else if(l+r < N){
//                leftIdx++;
//            }else{
//                rightIdx--;
//            }
//        }
//        return answer;
//    }
}
