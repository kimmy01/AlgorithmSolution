package com.algo2022_01;

import java.util.*;
import java.io.*;

public class Main16947 {
    static int N, cnt;
    static ArrayList<Integer>[] subway;
    static int[] array;
    public static void main(String[] args) throws Exception {
        input();
        func();
    }
    static void func() {
        for(int i=1; i<=N; i++){
            if(array[i] == 0) {
                break;
            }
            dfs(new ArrayList<>(), new boolean[N+1], i, i);
        }
        for(int i=1; i<=N; i++){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
        for(int i=1; i<=N; i++){
            cnt = 0;
            if(array[i] < 0){
                count(i, new boolean[N+1], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(array[i] + " ");
        }
        System.out.println(sb.toString());
    }
    static void count(int next, boolean[] checked, int start){
        if(array[start] > 0){
            array[start] = Math.min(array[start], cnt);
            return;
        }
        if(array[next] == 0){
            array[start] = cnt;
            return;
        }
        cnt++;
        checked[next] = true;
        for(int i=0; i<subway[next].size(); i++){
            if(checked[subway[next].get(i)]) continue;
            count(subway[next].get(i), checked, start);
        }
    }
    static void dfs(ArrayList<Integer> list, boolean[] checked, int next, int start) {
        if(list.size() > 0 && start == next){
            int first = list.get(1);
            int last = list.get(list.size()-1);
            if(first == last) return;
            for(int i=0; i<list.size(); i++){
                int tmp = list.get(i);
                array[tmp] = 0;
            }
            return;
        }
        checked[next] = true;
        list.add(next);
        for(int i=0; i<subway[next].size(); i++){
            if(subway[next].get(i) == start){
                dfs(list, checked, subway[next].get(i), start);
            }
            if(!checked[subway[next].get(i)]){
                dfs(list, checked, subway[next].get(i), start);
            }
        }
        list.remove(Integer.valueOf(next));
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N+1];
        subway = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            subway[i] = new ArrayList();
            array[i] = -1;
        }
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            subway[a].add(b);
            subway[b].add(a);
        }
    }
}
