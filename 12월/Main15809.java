package com.algo12;

import java.util.*;
import java.io.*;

public class Main15809 {
    static class Relation{
        int state;
        int first;
        int second;
        public Relation(int state, int first, int second){
            this.state = state;
            this.first = first;
            this.second = second;
        }
    }
    static int N, M;
    static int[] army;
    static int[] arr;
    static Relation[] relationship;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    private static void func() {
        for(int i=0; i<M; i++){
            if(relationship[i].state == 1){ //동맹
                union(relationship[i].first, relationship[i].second);
            }else{ //전쟁
                int a = find(relationship[i].first);
                int b = find(relationship[i].second);
                int aSum = army[a];
                int bSum = army[b];
                if(aSum > bSum){
                    army[a] = aSum - bSum;
                    army[b] = 0;
                    union(a, b);
                }else if(aSum < bSum){
                    army[b] = bSum - aSum;
                    army[a] = 0;
                    union(b, a);
                }else{
                    army[a] = 0;
                    army[b] = 0;
                }
            }
        }
        Arrays.sort(army);
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(army[i] > 0){
                list.add(army[i]);
                answer++;
            }
        }
        System.out.println(answer);
        for(int a : list){
            System.out.print(a + " ");
        }
    }
    private static int find(int n){
        if(n == arr[n])
            return n;
        return arr[n] = find(arr[n]);
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            arr[b] = a;
            army[a] += army[b];
            army[b] = 0;
        }
    }
    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        army = new int[N+1];
        arr = new int[N+1];
        relationship = new Relation[M];
        for(int i=0; i<=N; i++){
            arr[i] = i;
        }
        for(int i=1; i<=N; i++){
            army[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int O = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            relationship[i] = new Relation(O, P, Q);
        }
    }
}
