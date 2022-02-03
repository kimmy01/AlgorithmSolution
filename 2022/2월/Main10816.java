package com.algo2022_02;

import java.io.*;
import java.util.*;

public class Main10816 {
    static int N, M;
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(map.containsKey(tmp)){
                map.replace(tmp, map.get(tmp)+1);
            }else{
                map.put(tmp, 1);
            }
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int n = Integer.parseInt(st.nextToken());
            if(map.containsKey(n)){
                sb.append(map.get(n)+ " ");
            }else{
                sb.append(0 + " ");
            }
        }
        System.out.println(sb.toString());
    }
}
