package com.algo0405;

import java.util.*;
import java.io.*;

public class Main_BOJ_1043_거짓말 {
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); //사람 수
        int M = Integer.parseInt(st.nextToken()); //파티 수
        st = new StringTokenizer(br.readLine(), " ");
        parent = new int[N+1];
        list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            parent[i] = -1;
        }
        st.nextToken();
        while(st.hasMoreTokens()){
            int temp = Integer.parseInt(st.nextToken());
            parent[temp] = temp;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int temp = Integer.parseInt(st.nextToken());
            list.add(new ArrayList<>());
            for(int j=0; j<temp; j++){
                int person = Integer.parseInt(st.nextToken());
                list.get(i).add(person);
            }
            if(list.get(i).size() >= 2){
                union2(i);
            }
        }
        int count = 0;
        for(int i=0; i<M; i++){
            if(isPossible(i)) count++;
        }
        System.out.println(count);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(a == parent[a]){
                parent[b] = a;
            }else{
                parent[a] = b;
            }

        }
    }
    static int find(int x){
        if(x == parent[x] || parent[x] < 0) return x;
        return parent[x] = find(parent[x]);
    }

    static void union2(int i){
        int a = list.get(i).get(0);
        for(int j=1; j<list.get(i).size(); j++){
            union(a, list.get(i).get(j));
        }
    }

    static boolean isPossible(int i) {
        for (int j = 0; j < list.get(i).size(); j++) {
            int temp = find(list.get(i).get(j));
            if (parent[temp] == temp) return false;
        }
        return true;
    }
}
