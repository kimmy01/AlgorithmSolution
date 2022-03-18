package com.algo2022_03;

import java.util.*;
import java.io.*;

public class Main14675 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int Q = Integer.parseInt(br.readLine());
        for(int i=0; i<Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(t == 2){
                System.out.println("yes");
            }else{
                int count = 0;
                for(int a : list[k]){
                    count++;
                }
                if(count >= 2) System.out.println("yes");
                else System.out.println("no");
            }
        }
    }
}
